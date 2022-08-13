package com.islandmodel.entity.animal;

import com.islandmodel.Config;
import com.islandmodel.entity.Entity;
import com.islandmodel.entity.EntityType;
import com.islandmodel.island.Location;
import com.islandmodel.utils.Randomizer;

import java.util.ArrayList;
import java.util.List;

public class Animal extends Entity {

    private int saturation;
    private boolean canMove;

    @Override
    public void itIsNewDay() {
        this.canMove = true;
        saturation = 0;
        super.itIsNewDay();
    }

    public void canNotMove() {
        this.canMove = false;
    }

    public boolean isCanMove() {
        return canMove;
    }

    protected Animal(EntityType type) {
        super(type);
        this.canMove = false;
    }

    private ArrayList<Entity> makeMenu(Animal animalEater, Location currentLocation) {
        ArrayList<Entity> result = new ArrayList<>();
        for (int entityTypeForFood = 0; entityTypeForFood < EntityType.values().length; entityTypeForFood++) {
            if (animalEater.onTheMenu(entityTypeForFood)) {
                result.addAll(currentLocation.getOneTypeOfEntitiesToLocation(entityTypeForFood));
            }
        }
        return result;
    }

    public int getSaturation() {
        return saturation;
    }

    public void setSaturation(int saturation) {
        this.saturation = Math.min(this.saturation + saturation, Config.MAX_SATURATION[this.getType().ordinal()]);
    }

    @Override
    public void multiply(Location currentLocation) {
        safeMultiply(currentLocation);
    }

    private void safeMultiply(Location currentLocation) {
        currentLocation.getLock().lock();
        try {
            int sameAnimalTypeQuantity = currentLocation.getOneTypeOfEntitiesToLocation(getType().ordinal()).size();
            int maxQuantityInLocation = Config.MAX_PER_LOCATION[getType().ordinal()];
            int newChildrenQuantity = Math.min(maxQuantityInLocation - sameAnimalTypeQuantity, sameAnimalTypeQuantity / 2);
            if (sameAnimalTypeQuantity > 1) {
                for (int i = 0; i < newChildrenQuantity; i++) {
                    if (Randomizer.getRandomBoolean(50)) {//шанс на успех родить
                        currentLocation.addEntityToLocation(getType().ordinal());
                    }
                }
            }
        } finally {
            currentLocation.getLock().unlock();
        }
    }

    public boolean eat(Location currentLocation) {
        return safeEat(currentLocation);
    }

    private boolean safeEat(Location currentLocation) {
        currentLocation.getLock().lock();
        boolean ate = false;

        try {
            ArrayList<Entity> menu = makeMenu(this, currentLocation);
            for (Entity entity : menu) {
                int chance = Config.CHANCES_TO_EAT[this.getType().ordinal()][entity.getType().ordinal()];
                if (Randomizer.getRandomBoolean(chance)) {
                    entity.setRemovable();
                    setSaturation(entity.getWeight()); //вес жертвы должен перейти в желудок поедателя и все(т.к. среди нас нет падльщиков)
                }
                if (this.getSaturation() == Config.MAX_SATURATION[this.getType().ordinal()]) {
                    ate = true;
                    break;
                }
            }
        } finally {
            currentLocation.getLock().unlock();
        }
        return ate;
    }

    public void move(Location currentLocation) {
        safeMove(currentLocation);
    }

    private void safeMove(Location currentLocation) {
        currentLocation.getLock().lock();
        try {
            int speed = getSpeed(this.getType().ordinal());
            if (speed > 0 && isCanMove()) {
                Location destinationLocation = getNextLocation(currentLocation, speed);
                ArrayList<Entity> currentLocationEntities = currentLocation.getOneTypeOfEntitiesToLocation(this.getType().ordinal());
                currentLocationEntities.remove(this);

                ArrayList<Entity> destinationLocationEntities = destinationLocation.getOneTypeOfEntitiesToLocation(this.getType().ordinal());
                destinationLocationEntities.add(this);//беспалева добавили существо в список организмов соседней локации, вот для чего нужен отдельный список задач Task
            }
            canNotMove();
        } finally {
            currentLocation.getLock().unlock();
        }
    }

    private int getSpeed(int type) {
        int maxSpeed = Config.TRAVEL_DISTANCE[type];
        return Randomizer.getRandom(0, maxSpeed);
    }

    private Location getNextLocation(Location currentArea, int currentSpeed) {
        List<Location> nearbyLocations = currentArea.getNearbyLocations();
        if (currentSpeed > 0) {
            int nextAreaIndex = Randomizer.getRandom(0, nearbyLocations.size() - 1);
            return getNextLocation(nearbyLocations.get(nextAreaIndex - 1), currentSpeed - 1);
        } else {
            return currentArea;
        }
    }
}


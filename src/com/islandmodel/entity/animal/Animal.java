package com.islandmodel.entity.animal;

import com.islandmodel.Config;
import com.islandmodel.entity.Entity;
import com.islandmodel.entity.EntityType;
import com.islandmodel.island.Location;
import com.islandmodel.utils.Randomizer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Animal extends Entity {

    private int saturation;
    private boolean canMove;

    protected Animal(EntityType type) {
        super(type);
        this.canMove = false;
    }

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

    private int getSaturation() {
        return saturation;
    }

    public void setSaturation(int saturation) {
        this.saturation = Math.min(this.saturation + saturation, Config.MAX_SATURATION[this.getType().ordinal()]);
    }

    private Set<Entity> makeMenu(Animal animalEater, Location currentLocation) {
        Set<Entity> result = new HashSet<>() {
        };
        for (int entityTypeForFood = 0; entityTypeForFood < EntityType.values().length; entityTypeForFood++) {
            if (animalEater.onTheMenu(entityTypeForFood)) {
                result.addAll(currentLocation.getOneTypeOfEntitiesToLocation(entityTypeForFood));
            }
        }
        return result;
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
            Set<Entity> menu = makeMenu(this, currentLocation);
            for (Entity entity : menu) {
                int chance = Config.CHANCES_TO_EAT[this.getType().ordinal()][entity.getType().ordinal()];
                if (Randomizer.getRandomBoolean(chance)) {
                    entity.setRemovable();
                    setSaturation(entity.getWeight());
                }
                if (this.getSaturation() == Config.MAX_SATURATION[this.getType().ordinal()]) {
                    entity.setRemovable();
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
                if (destinationLocation == currentLocation) {
                    return;
                }
                Set<Entity> currentLocationEntities = currentLocation.getOneTypeOfEntitiesToLocation(this.getType().ordinal());

                currentLocationEntities.remove(this);

                Set<Entity> destinationLocationEntities = destinationLocation.getOneTypeOfEntitiesToLocation(this.getType().ordinal());
                destinationLocationEntities.add(this);
                this.canNotMove();
            }

        } finally {
            currentLocation.getLock().unlock();
        }
    }

    private Location getNextLocation(Location currentArea, int currentSpeed) {
        List<Location> nearbyLocations = currentArea.getNearbyLocations();
        if (currentSpeed > 0) {
            int nextLocationIndex = Randomizer.getRandom(0, nearbyLocations.size() - 1);
            return getNextLocation(nearbyLocations.get(nextLocationIndex), currentSpeed - 1);
        } else {
            return currentArea;
        }
    }

    private int getSpeed(int type) {
        return Config.TRAVEL_DISTANCE[type];
    }
}


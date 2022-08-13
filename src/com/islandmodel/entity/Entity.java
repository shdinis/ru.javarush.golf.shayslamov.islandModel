package com.islandmodel.entity;

import com.islandmodel.Config;
import com.islandmodel.entity.animal.herbivore.*;
import com.islandmodel.entity.animal.predator.*;
import com.islandmodel.entity.plant.Plant;
import com.islandmodel.island.Location;

public abstract class Entity {

    private final EntityType type;
    private boolean removable;
    private int weight;
    private int age;

    public abstract void multiply(Location currentLocation);

    public static Entity returnNewEntity(int random) {
        return switch (random) {
            case 0 -> new Bear();
            case 1 -> new Boa();
            case 2 -> new Eagle();
            case 3 -> new Fox();
            case 4 -> new Wolf();
            case 5 -> new Boar();
            case 6 -> new Buffalo();
            case 7 -> new Caterpillar();
            case 8 -> new Deer();
            case 9 -> new Duck();
            case 10 -> new Goat();
            case 11 -> new Horse();
            case 12 -> new Mouse();
            case 13 -> new Rabbit();
            case 14 -> new Sheep();
            default -> new Plant();
        };
    }

    protected Entity(EntityType type) {
        this.type = type;
        this.removable = false;
        this.weight = Config.ENTITY_WEIGHT[type.ordinal()];
        this.age = 0;
    }

    public EntityType getType() {
        return type;
    }

    public void setRemovable() {
        this.removable = true;
    }

    public boolean isRemovable() {
        return removable;
    }

    public int getWeight() {
        return weight;
    }

    public boolean onTheMenu(int entityForFoodType) {
        return Config.CHANCES_TO_EAT[this.type.ordinal()][entityForFoodType] != 0;
    }

    public int getAge() {
        return age;
    }

    public void setAge() {
        ++this.age;
    }

    public void itIsNewDay() {
        setAge();
        if (getAge() > Config.MAX_AGE_ENTITIES[getType().ordinal()]) {
            setRemovable();
        }
    }

    @Override
    public String toString() {
        return type.getIcon();
    }
}
package com.islandmodel.entitie;

import com.islandmodel.Config;
import com.islandmodel.entitie.animal.Animal;
import com.islandmodel.entitie.animal.herbivore.*;
import com.islandmodel.entitie.animal.predator.*;
import com.islandmodel.entitie.plant.Plant;

public class Entitie {

    private final EntitieType type;
    private boolean removable;
    private int weight;

    public static Entitie returnNewEntity(int random) {
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

    public Entitie(EntitieType type) {
        this.type = type;
        this.removable = false;
        this.weight = Config.ENTITY_WEIGHT[type.ordinal()];
    }

    public EntitieType getType() {
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

    public boolean onTheMenu(Entitie entitieForFood) {
        return Config.CHANCES_TO_EAT[this.type.ordinal()][entitieForFood.type.ordinal()] != 0;
    }

    @Override
    public String toString() {
        return type.getIcon();
    }
}

package com.IslandModel.entities.animals.herbivores;

import com.IslandModel.entities.animals.TypesOfAnimals;

public class Horse extends Herbivore{

    public Horse() {
        super(TypesOfAnimals.HORSE);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC0E";
    }
}

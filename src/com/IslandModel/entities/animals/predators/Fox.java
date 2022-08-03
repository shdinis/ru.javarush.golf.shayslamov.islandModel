package com.IslandModel.entities.animals.predators;

import com.IslandModel.entities.animals.TypesOfAnimals;

public class Fox extends Predator{

    public Fox() {
        super(TypesOfAnimals.FOX);
    }

    @Override
    public String toString() {
        return "\uD83E\uDD8A";
    }
}

package com.IslandModel.entities.animals.predators;

import com.IslandModel.entities.animals.TypesOfAnimals;

public class Eagle extends Predator{

    public Eagle() {
        super(TypesOfAnimals.EAGLE);
    }

    @Override
    public String toString() {
        return "\uD83E\uDD85";
    }
}

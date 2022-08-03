package com.IslandModel.entities.animals.predators;

import com.IslandModel.entities.animals.TypesOfAnimals;

public class Boa extends Predator{

    public Boa() {
        super(TypesOfAnimals.BOA);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC0D";
    }
}

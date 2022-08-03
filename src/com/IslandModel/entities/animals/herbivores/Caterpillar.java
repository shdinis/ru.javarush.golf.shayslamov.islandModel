package com.IslandModel.entities.animals.herbivores;

import com.IslandModel.entities.animals.TypesOfAnimals;

public class Caterpillar extends Herbivore{

    public Caterpillar() {
        super(TypesOfAnimals.CATERPILLAR);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC1B";
    }
}

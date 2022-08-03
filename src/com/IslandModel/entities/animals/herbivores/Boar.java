package com.IslandModel.entities.animals.herbivores;

import com.IslandModel.entities.animals.TypesOfAnimals;

public class Boar extends Herbivore {

    public Boar() {
        super(TypesOfAnimals.BOAR);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC17";
    }

}

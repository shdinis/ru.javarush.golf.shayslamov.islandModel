package com.IslandModel.entities.animals.herbivores;

import com.IslandModel.entities.animals.TypesOfAnimals;

public class Goat extends Herbivore{

    public Goat() {
        super(TypesOfAnimals.GOAT);
    }
    @Override
    public String toString() {
        return "\uD83D\uDC10";
    }
}

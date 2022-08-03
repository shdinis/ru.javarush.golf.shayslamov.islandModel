package com.IslandModel.entities.animals.herbivores;

import com.IslandModel.entities.animals.TypesOfAnimals;

public class Buffalo extends Herbivore{

    public Buffalo() {
        super(TypesOfAnimals.BUFFALO);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC03";
    }
}

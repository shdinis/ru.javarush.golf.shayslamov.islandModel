package com.IslandModel.entities.animals.herbivores;

import com.IslandModel.entities.animals.TypesOfAnimals;

public class Sheep extends Herbivore{

    public Sheep() {
        super(TypesOfAnimals.SHEEP);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC11";
    }
}

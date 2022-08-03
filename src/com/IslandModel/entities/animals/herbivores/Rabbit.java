package com.IslandModel.entities.animals.herbivores;

import com.IslandModel.entities.animals.TypesOfAnimals;

public class Rabbit extends Herbivore {

    public Rabbit() {
        super(TypesOfAnimals.RABBIT);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC07";
    }
}

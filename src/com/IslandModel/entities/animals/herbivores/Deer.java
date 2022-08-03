package com.IslandModel.entities.animals.herbivores;

import com.IslandModel.entities.animals.TypesOfAnimals;

public class Deer extends Herbivore{

    public Deer() {
        super(TypesOfAnimals.DEER);
    }

    @Override
    public String toString() {
        return "\uD83E\uDD8C";
    }
}

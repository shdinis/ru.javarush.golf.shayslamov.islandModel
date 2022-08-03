package com.IslandModel.entities.animals.herbivores;

import com.IslandModel.entities.animals.TypesOfAnimals;

public class Duck extends Herbivore{

    public Duck() {
        super(TypesOfAnimals.DUCK);
    }


    @Override
    public String toString() {
        return "\uD83E\uDD86";
    }
}

package com.IslandModel.entities.animals.herbivores;

import com.IslandModel.entities.animals.TypesOfAnimals;

public class Mouse extends Herbivore{

    public Mouse() {
        super(TypesOfAnimals.MOUSE);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC01";
    }
}

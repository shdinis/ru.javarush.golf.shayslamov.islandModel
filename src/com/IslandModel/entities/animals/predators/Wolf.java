package com.IslandModel.entities.animals.predators;

import com.IslandModel.entities.animals.TypesOfAnimals;

public class Wolf extends Predator {

    private int saturation = 0;//насыщение
    public static final int MAX_SATURATION =  8000;

    public Wolf() {
        super(TypesOfAnimals.WOLF);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC3A";
    }
}

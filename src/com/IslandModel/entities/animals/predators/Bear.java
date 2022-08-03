package com.IslandModel.entities.animals.predators;

import com.IslandModel.entities.animals.TypesOfAnimals;

public class Bear extends Predator {
    private int saturation = 0;//насыщение

//    public static final int MAX_SATURATION = 80000;

    public Bear() {
        super(TypesOfAnimals.BEAR);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC3B";
    }

}

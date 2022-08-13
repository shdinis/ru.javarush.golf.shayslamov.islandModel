package com.islandmodel.entity.animal.herbivore;

import com.islandmodel.entity.EntityType;

public class Goat extends Herbivore{

    public Goat() {
        super(EntityType.GOAT);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC10";
    }
}

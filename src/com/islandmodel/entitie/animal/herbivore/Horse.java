package com.islandmodel.entitie.animal.herbivore;

import com.islandmodel.entitie.EntitieType;

public class Horse extends Herbivore{

    public Horse() {
        super(EntitieType.HORSE);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC0E";
    }
}

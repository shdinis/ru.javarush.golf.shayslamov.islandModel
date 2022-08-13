package com.islandmodel.entity.animal.herbivore;

import com.islandmodel.entity.EntityType;

public class Horse extends Herbivore {

    public Horse() {
        super(EntityType.HORSE);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC0E";
    }
}

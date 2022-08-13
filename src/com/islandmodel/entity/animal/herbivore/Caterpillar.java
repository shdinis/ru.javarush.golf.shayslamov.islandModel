package com.islandmodel.entity.animal.herbivore;

import com.islandmodel.entity.EntityType;

public class Caterpillar extends Herbivore{

    public Caterpillar() {
        super(EntityType.CATERPILLAR);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC1B";
    }
}

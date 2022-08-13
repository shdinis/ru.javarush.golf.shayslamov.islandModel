package com.islandmodel.entity.animal.herbivore;

import com.islandmodel.entity.EntityType;

public class Boar extends Herbivore {

    public Boar() {
        super(EntityType.BOAR);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC17";
    }

}

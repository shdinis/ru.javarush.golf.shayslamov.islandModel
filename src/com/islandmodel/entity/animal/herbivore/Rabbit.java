package com.islandmodel.entity.animal.herbivore;

import com.islandmodel.entity.EntityType;

public class Rabbit extends Herbivore {

    public Rabbit() {
        super(EntityType.RABBIT);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC07";
    }
}

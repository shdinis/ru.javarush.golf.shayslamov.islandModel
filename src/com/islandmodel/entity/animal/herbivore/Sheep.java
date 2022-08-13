package com.islandmodel.entity.animal.herbivore;

import com.islandmodel.entity.EntityType;

public class Sheep extends Herbivore{

    public Sheep() {
        super(EntityType.SHEEP);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC11";
    }
}

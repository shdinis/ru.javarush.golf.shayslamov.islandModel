package com.islandmodel.entity.animal.herbivore;

import com.islandmodel.entity.EntityType;

public class Buffalo extends Herbivore{

    public Buffalo() {
        super(EntityType.BUFFALO);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC03";
    }
}

package com.islandmodel.entity.animal.predator;

import com.islandmodel.entity.EntityType;

public class Wolf extends Predator {

    public Wolf() {
        super(EntityType.WOLF);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC3A";
    }
}

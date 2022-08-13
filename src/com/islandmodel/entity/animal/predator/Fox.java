package com.islandmodel.entity.animal.predator;

import com.islandmodel.entity.EntityType;

public class Fox extends Predator{

    public Fox() {
        super(EntityType.FOX);
    }

    @Override
    public String toString() {
        return "\uD83E\uDD8A";
    }
}

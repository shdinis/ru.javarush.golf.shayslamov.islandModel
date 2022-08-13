package com.islandmodel.entity.animal.herbivore;

import com.islandmodel.entity.EntityType;

public class Deer extends Herbivore{

    public Deer() {
        super(EntityType.DEER);
    }

    @Override
    public String toString() {
        return "\uD83E\uDD8C";
    }
}

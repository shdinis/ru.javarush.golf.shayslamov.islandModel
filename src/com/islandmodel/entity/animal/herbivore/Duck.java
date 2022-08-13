package com.islandmodel.entity.animal.herbivore;

import com.islandmodel.entity.EntityType;

public class Duck extends Herbivore{

    public Duck() {
        super(EntityType.DUCK);
    }

    @Override
    public String toString() {
        return "\uD83E\uDD86";
    }
}

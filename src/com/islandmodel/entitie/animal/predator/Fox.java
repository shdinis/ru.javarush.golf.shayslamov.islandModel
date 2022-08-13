package com.islandmodel.entitie.animal.predator;

import com.islandmodel.entitie.EntitieType;

public class Fox extends Predator{

    public Fox() {
        super(EntitieType.FOX);
    }

    @Override
    public String toString() {
        return "\uD83E\uDD8A";
    }
}

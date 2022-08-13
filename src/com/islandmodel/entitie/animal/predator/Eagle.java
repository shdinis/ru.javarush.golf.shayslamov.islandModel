package com.islandmodel.entitie.animal.predator;

import com.islandmodel.entitie.EntitieType;

public class Eagle extends Predator{

    public Eagle() {
        super(EntitieType.EAGLE);
    }

    @Override
    public String toString() {
        return "\uD83E\uDD85";
    }
}

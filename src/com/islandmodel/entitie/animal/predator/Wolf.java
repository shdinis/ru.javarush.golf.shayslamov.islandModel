package com.islandmodel.entitie.animal.predator;

import com.islandmodel.entitie.EntitieType;

public class Wolf extends Predator {

    public Wolf() {
        super(EntitieType.WOLF);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC3A";
    }
}

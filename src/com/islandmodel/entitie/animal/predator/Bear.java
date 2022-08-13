package com.islandmodel.entitie.animal.predator;

import com.islandmodel.entitie.EntitieType;

public class Bear extends Predator {
    private int saturation = 0;//насыщение

    public Bear() {
        super(EntitieType.BEAR);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC3B";
    }

}

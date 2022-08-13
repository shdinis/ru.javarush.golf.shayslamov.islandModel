package com.islandmodel.entitie.animal.herbivore;

import com.islandmodel.entitie.EntitieType;

public class Buffalo extends Herbivore{

    public Buffalo() {
        super(EntitieType.BUFFALO);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC03";
    }
}

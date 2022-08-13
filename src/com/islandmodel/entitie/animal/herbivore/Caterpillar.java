package com.islandmodel.entitie.animal.herbivore;

import com.islandmodel.entitie.EntitieType;

public class Caterpillar extends Herbivore{

    public Caterpillar() {
        super(EntitieType.CATERPILLAR);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC1B";
    }
}

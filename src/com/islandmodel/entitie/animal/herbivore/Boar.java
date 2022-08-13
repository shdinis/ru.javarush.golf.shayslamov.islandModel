package com.islandmodel.entitie.animal.herbivore;

import com.islandmodel.entitie.EntitieType;

public class Boar extends Herbivore {

    public Boar() {
        super(EntitieType.BOAR);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC17";
    }

}

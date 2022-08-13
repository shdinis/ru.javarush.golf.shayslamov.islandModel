package com.islandmodel.entitie.animal.herbivore;

import com.islandmodel.entitie.EntitieType;

public class Goat extends Herbivore{

    public Goat() {
        super(EntitieType.GOAT);
    }
    @Override
    public String toString() {
        return "\uD83D\uDC10";
    }
}

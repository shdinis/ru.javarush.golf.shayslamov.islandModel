package com.islandmodel.entitie.animal.predator;

import com.islandmodel.entitie.EntitieType;

public class Boa extends Predator{

    public Boa() {
        super(EntitieType.BOA);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC0D";
    }
}

package com.islandmodel.entitie.animal.herbivore;

import com.islandmodel.entitie.EntitieType;

public class Sheep extends Herbivore{

    public Sheep() {
        super(EntitieType.SHEEP);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC11";
    }
}

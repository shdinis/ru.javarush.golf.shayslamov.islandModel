package com.islandmodel.entitie.animal.herbivore;

import com.islandmodel.entitie.EntitieType;

public class Rabbit extends Herbivore {

    public Rabbit() {
        super(EntitieType.RABBIT);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC07";
    }
}

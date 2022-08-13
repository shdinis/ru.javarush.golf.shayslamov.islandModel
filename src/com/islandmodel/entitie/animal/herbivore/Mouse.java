package com.islandmodel.entitie.animal.herbivore;

import com.islandmodel.entitie.EntitieType;

public class Mouse extends Herbivore{

    public Mouse() {
        super(EntitieType.MOUSE);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC01";
    }
}

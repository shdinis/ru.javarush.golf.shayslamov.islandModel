package com.islandmodel.entity.animal.herbivore;

import com.islandmodel.entity.EntityType;

public class Mouse extends Herbivore{

    public Mouse() {
        super(EntityType.MOUSE);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC01";
    }
}

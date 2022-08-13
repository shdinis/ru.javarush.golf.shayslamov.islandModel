package com.islandmodel.entity.animal.predator;

import com.islandmodel.entity.EntityType;

public class Boa extends Predator{

    public Boa() {
        super(EntityType.BOA);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC0D";
    }
}

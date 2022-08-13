package com.islandmodel.entitie.animal.herbivore;

import com.islandmodel.entitie.EntitieType;

public class Deer extends Herbivore{

    public Deer() {
        super(EntitieType.DEER);
    }

    @Override
    public String toString() {
        return "\uD83E\uDD8C";
    }
}

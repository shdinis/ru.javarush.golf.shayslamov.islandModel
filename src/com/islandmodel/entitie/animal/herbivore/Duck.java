package com.islandmodel.entitie.animal.herbivore;

import com.islandmodel.entitie.EntitieType;

public class Duck extends Herbivore{

    public Duck() {
        super(EntitieType.DUCK);
    }


    @Override
    public String toString() {
        return "\uD83E\uDD86";
    }
}

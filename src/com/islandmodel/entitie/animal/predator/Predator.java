package com.islandmodel.entitie.animal.predator;

import com.islandmodel.Config;
import com.islandmodel.entitie.animal.Animal;
import com.islandmodel.entitie.EntitieType;
import com.islandmodel.island.location.Coordinate;
import com.islandmodel.island.location.EntitiesToLocation;
import com.islandmodel.utils.Randomizer;

import java.util.ArrayList;

public abstract class Predator extends Animal {

    public Predator(EntitieType type) {
        super(type);
    }

    @Override
    public void eat(EntitiesToLocation menuEntitiesToLocation) {
        menuEntitiesToLocation


        for (int i = 0; i < menuEntitiesToLocation.getAnimals().size(); i++) {
            int random = Randomizer.getRandom(100);
            int chance = Config.CHANCES_TO_EAT[this.getType().ordinal()][menuEntitiesToLocation.getAnimals().get(i).getType().ordinal()];
            if (random >= chance) {
                menuEntitiesToLocation.getAnimals().get(i).setDead();
                setSaturation(menuEntitiesToLocation.getAnimals().get(i).getWeight()); //вес жертвы должен перейти в желудок поедателя и все(т.к. среди нас нет падьщиков)
            }
        }
    }

    @Override
    public Coordinate chooseDirection(ArrayList<Coordinate> coordinateToMove) {
        return null;
    }
}


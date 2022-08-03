package com.IslandModel.entities.animals.predators;

import com.IslandModel.entities.animals.Animal;
import com.IslandModel.entities.animals.Matrix;
import com.IslandModel.entities.animals.TypesOfAnimals;
import com.IslandModel.island.Entities;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Predator extends Animal {


    public Predator(TypesOfAnimals type) {
        super(type);
    }

    @Override
    public void eat(Entities menuEntities) {
        for (int i = 0; i < menuEntities.getAnimals().size(); i++) {
            int random = ThreadLocalRandom.current().nextInt(100);
            int chance = Matrix.CHANCES_TO_EAT[this.type.ordinal()][menuEntities.getAnimals().get(i).type.ordinal()];
            if (random >= chance) {
                menuEntities.getAnimals().get(i).setDead();
                setSaturation(menuEntities.getAnimals().get(i).getWeight()); //вес жертвы должен перейти в желудок поедателя и все(т.к. среди нас нет падьщиков)
            }
        }
    }
}


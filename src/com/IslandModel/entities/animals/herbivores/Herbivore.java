package com.IslandModel.entities.animals.herbivores;

import com.IslandModel.entities.animals.Animal;
import com.IslandModel.entities.animals.TypesOfAnimals;
import com.IslandModel.island.Entities;

public class Herbivore extends Animal {

    public Herbivore(TypesOfAnimals type) {
        super(type);
    }

    @Override
    public void eat(Entities menuEntities) {
        for (int i = 0; i < menuEntities.getPlants().size(); i++) {
                menuEntities.getPlants().get(i).setBitten();

                setSaturation(menuEntities.getPlants().get(i).getWeight()); //вес жертвы должен перейти в желудок поедателя и все(т.к. среди нас нет падьщиков)

        }
    }
}

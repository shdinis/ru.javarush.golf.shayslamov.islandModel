package com.IslandModel.island;

import com.IslandModel.entities.animals.Animal;
import com.IslandModel.entities.animals.herbivores.Herbivore;
import com.IslandModel.entities.plants.Plant;

public class Location {

    // Списки где будут хранитсья находящиеся на локации сущности

    private Entities entities = new Entities();


    public void calculate() {

        for (int i = 0; i < entities.getAnimals().size(); i++) {
            Animal animal = entities.getAnimals().get(i);

            if (!animal.isDead()) {
                animal.eat(makeMenu(animal));
            }


            //размножаемся
//            animal.multiply();

            //перемещаемся
//            animal.chooseDirection();

        }
    }

    private Entities makeMenu(Animal animal) {
        Entities result = new Entities();
        for (int j = 0; j < entities.getAnimals().size(); j++) {
            if (animal != entities.getAnimals().get(j) && animal.onTheMenu(entities.getAnimals().get(j))) {
                result.getAnimals().add(entities.getAnimals().get(j));
            }
        }
        if (animal instanceof Herbivore){
            result.getPlants().addAll(entities.getPlants());
        }
        return result;
    }

    public void addAnimalToLocation(Animal animal) {
//        entities.animals.add(animal);
        entities.getAnimals().add(animal);
    }

    public void addPlantToLocation(Plant plant) {
//        entities.plants.add(plant);
        entities.getPlants().add(plant);
    }

    public int getPlantsSizeToLocation() {
        return entities.getPlants().size();
    }

    public void cleaningAnimalsPlantLists() {
        for (int i = 0; i < entities.getAnimals().size(); i++) {
            if (entities.getAnimals().get(i).isDead()) {
                entities.getAnimals().remove(i);
                i--;
            }
        }
        for (int i = 0; i < entities.getPlants().size(); i++) {
            if (entities.getPlants().get(i).isBitten()) {
                entities.getPlants().remove(i);
                i--;
            }
        }
    }

    public String toString() {
        return " |" + entities.getAnimals().toString() + "#" + entities.getPlants().toString() + "|    ";
    }
}

package com.IslandModel.island;

import com.IslandModel.entities.animals.Animal;
import com.IslandModel.entities.animals.Matrix;
import com.IslandModel.entities.animals.TypesOfAnimals;
import com.IslandModel.entities.animals.herbivores.*;
import com.IslandModel.entities.animals.predators.*;
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
        }

        //размножение
        for (int i = 0; i < TypesOfAnimals.values().length; i++) {
            int count = 0;
            for (int j = 0; j < entities.getAnimals().size(); j++) {
                if (entities.getAnimals().get(j).type == TypesOfAnimals.valueOf(String.valueOf(i))) {//проверить не создается ли тут животное при счетчике равном нулю!!!
                    count++;
                }
            }
            count = (count == Matrix.MAX_PER_LOCATION[i]) ? 0 : (Matrix.MAX_PER_LOCATION[i] + count) % Matrix.MAX_PER_LOCATION[i];///тут проверяем максимальное число на ячейку
            for (int j = 0; j < (count / 2); j++) {///как то нужно ограничить количество на одной ячейке
                entities.getAnimals().add(returnNewAnimal(i));
            }
        }

        //перемещаемся
//            animal.chooseDirection();

    }


    private Entities makeMenu(Animal animal) {
        Entities result = new Entities();
        for (int j = 0; j < entities.getAnimals().size(); j++) {
            if (animal != entities.getAnimals().get(j) && animal.onTheMenu(entities.getAnimals().get(j))) {
                result.getAnimals().add(entities.getAnimals().get(j));
            }
        }
        if (animal instanceof Herbivore) {
            result.getPlants().addAll(entities.getPlants());
        }
        return result;
    }

    public void addAnimalToLocation(Animal animal) {
        entities.getAnimals().add(animal);
    }

    public void addPlantToLocation(Plant plant) {
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

    public static Animal returnNewAnimal(int random) {
        Animal animal = switch (random) {
            case 0 -> new Bear();
            case 1 -> new Boa();
            case 2 -> new Eagle();
            case 3 -> new Fox();
            case 4 -> new Wolf();
            case 5 -> new Boar();
            case 6 -> new Buffalo();
            case 7 -> new Caterpillar();
            case 8 -> new Deer();
            case 9 -> new Duck();
            case 10 -> new Goat();
            case 11 -> new Horse();
            case 12 -> new Mouse();
            case 13 -> new Rabbit();
            default -> new Sheep();
        };
        return animal;
    }
}

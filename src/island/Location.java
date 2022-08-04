package island;

import animals.Animal;
import animals.herbivores.Herbivore;
import animals.predators.Predator;
import plants.Plant;

import java.util.List;
import java.util.ArrayList;

public class Location {

    // Списки где будут хранитсья находящиеся на локации сущности

    List<Animal> animals = new ArrayList<>();
    List<Plant> plants = new ArrayList<>();

    public void calculate() {

//        for (int i = 0; i < animals.size(); i++) {
//            Animal animal = animals.get(i);
//            animal.eat(animals);
//
//            //размножаемся
//            animal.multiply();
//
//            //перемещаемся
//            animal.chooseDirection();
//
//        }
    }

    public void addAnimalToLocation(Animal animal) {
        animals.add(animal);
    }

    public void addPlantToLocation(Plant plant) {
        plants.add(plant);
    }

    public void cleaningAnimalsPlantLists() {
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).isDead()){
                animals.remove(i);
                i--;
            }
        }
        for (int i = 0; i < plants.size(); i++) {
            if (plants.get(i).isBitten()){
                plants.remove(i);
                i--;
            }
        }
    }

    public String toString() {
        return " | | ";
    }
}

package com.islandmodel.island.location;

import com.islandmodel.Config;
import com.islandmodel.entitie.EntitieType;
import com.islandmodel.entitie.animal.Animal;
import com.islandmodel.entitie.animal.herbivore.*;
import com.islandmodel.entitie.animal.predator.*;
import com.islandmodel.entitie.plant.Plant;

import java.util.ArrayList;

import static com.islandmodel.utils.Randomizer.getRandom;

public class EntitiesToLocation {

    private ArrayList<Animal> animals = new ArrayList<>();// могу я это поле сделать финальным?
    private ArrayList<Plant> plants = new ArrayList<>();// могу я это поле сделать финальным?

    private ArrayList<Animal> getAnimals() {
        return animals;
    }

    private ArrayList<Plant> getPlants() {
        return plants;
    }

    private void addAnimal(Animal animal) {
        animals.add(animal);
    }

    private void addPlant(Plant plant) {
        plants.add(plant);
    }

    private void addPlants(ArrayList<Plant> plants) {
        this.plants.addAll(plants);
    }


    public void calculate() {
        for (Animal animal : getAnimals()) {

        }

        for (int i = 0; i < getAnimals().size(); i++) {
            Animal animal = getAnimals().get(i);
            if (!animal.isRemovable()) {
                animal.eat(makeMenu(animal));
            }
        }
        cleaningAnimalsPlantLists();

        //размножение
        for (int typeofAnimalToBreed = 0; typeofAnimalToBreed < EntitieType.values().length; typeofAnimalToBreed++) {
            int countOfAnimalThisType = 0;
            for (Animal animal : getAnimals()) {
                if (animal.getType().ordinal()==typeofAnimalToBreed) {
                    countOfAnimalThisType++;
                }
            }
//            for (int j = 0; j < getAnimals().size(); j++) {
//                if (getAnimals().get(j).getType() == EntitieType.valueOf(String.valueOf(typeofAnimalToBreed))) {//проверить не создается ли тут животное при счетчике равном нулю!!!
//                    countOfAnimalThisType++;
//                }
//            }
            countOfAnimalThisType = (countOfAnimalThisType == Config.MAX_PER_LOCATION[typeofAnimalToBreed]) ? 0 : (Config.MAX_PER_LOCATION[typeofAnimalToBreed] + countOfAnimalThisType) % Config.MAX_PER_LOCATION[typeofAnimalToBreed];///тут проверяем максимальное число на ячейку
            for (int j = 0; j < (countOfAnimalThisType / 2); j++) {///как то нужно ограничить количество на одной ячейке
                getAnimals().add(returnNewAnimal(typeofAnimalToBreed));
            }
        }

        //перемещаемся
        for (int i = 0; i < getAnimals().size(); i++) {
            Coordinate endingCoordinate = getAnimals().get(i).chooseDirection(coordinatesToMove(getAnimals().get(i)));
        }
    }

    //сделано
    private void cleaningAnimalsPlantLists() {
        animals.removeIf(Animal::isRemovable);
        plants.removeIf(Plant::isRemovable);
    }

    //сделано
    private EntitiesToLocation makeMenu(Animal animalEater) {
        EntitiesToLocation result = new EntitiesToLocation();
        for (Animal animalForFood : getAnimals()) {
            if (animalEater != animalForFood && animalEater.onTheMenu(animalForFood)) {
                result.addAnimal(animalForFood);
            }
        }
        if (animalEater instanceof Herbivore) {
            result.addPlants(getPlants());
        }
        return result;
    }

    public ArrayList<Coordinate> coordinatesToMove(Animal animal) {
//        int x = coordinate.getX();
//        int y = coordinate.getY();
        int travelDistance = Config.TRAVEL_DISTANCE[animal.getType().ordinal()];
        ArrayList<Coordinate> result = new ArrayList<>();

        for (int i = -travelDistance; i <= travelDistance; i++) {
            for (int j = -travelDistance; j <= travelDistance; j++) {
                if (0 <= i && i < Config.COLS && 0 <= j && j < Config.ROWS) {
                    result.add(Coordinate.newCoordinate(i, j));
                }
            }
        }
        return result;//нужно сделать чтобы возвращал координату через методы самого животного может какое нибудь житвотное боится кого нибудь и не хочет туда телепортироватся)))
    }

//    private void addAnimalToLocation(Animal animal) {
//        getAnimals().add(animal);
//    }

//    private void addPlantToLocation(Plant plant) {
//        getPlants().add(plant);
//    }

//    private int getPlantsSizeToLocation() {
//        return getPlants().size();
//    }

    public void initializeAnimal(int typeOfAnimalToCreate) {
        addAnimal(returnNewAnimal(typeOfAnimalToCreate));
    }

    @Override
    public String toString() {
        long herbCount = animals.stream().filter(animal -> animal instanceof Herbivore).count();
        long predCount = animals.stream().filter(animal -> animal instanceof Predator).count();
        return "Herb=" + herbCount + ", Predr=" + predCount + ", plant=" + plants.size();
    }
}


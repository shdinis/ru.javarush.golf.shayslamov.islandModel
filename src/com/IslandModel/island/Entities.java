package com.IslandModel.island;

import com.IslandModel.entities.animals.Animal;
import com.IslandModel.entities.plants.Plant;

import java.util.ArrayList;
import java.util.List;

public class Entities {

    private List<Animal> animals = new ArrayList<>();// могу я это поле сделать финальным?
    private List<Plant> plants = new ArrayList<>();// могу я это поле сделать финальным?

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Plant> getPlants() {
        return plants;
    }
}


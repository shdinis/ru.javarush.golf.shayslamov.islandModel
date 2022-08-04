package com.IslandModel.island;

import com.IslandModel.entities.animals.Animal;
import com.IslandModel.entities.plants.Plant;


import java.util.concurrent.ThreadLocalRandom;

import static com.IslandModel.island.Configurations.*;
import static com.IslandModel.island.Location.returnNewAnimal;


public final class Island {

    public static final Location[][] locations = new Location[WIDTH][HEIGHT];


    public void initialize() {
        for (int ix = 0; ix < locations.length; ix++) {
            for (int iy = 0; iy < locations[ix].length; iy++) {
                locations[ix][iy] = new Location();
            }
        }
    }

    public void initializeAnimal() {
        int maxCountPredators = 5;
        int maxCountHerbivores = 10;

        for (int i = 0; i < maxCountPredators; i++) {
            int animalType = ThreadLocalRandom.current().nextInt(0, 5);
            Animal predator = returnNewAnimal(animalType);

            locations[ThreadLocalRandom.current().nextInt(WIDTH)]
                    [ThreadLocalRandom.current().nextInt(HEIGHT)]
                    .addAnimalToLocation(predator);
        }

        for (int i = 0; i < maxCountHerbivores; i++) {
            int animalType = ThreadLocalRandom.current().nextInt(5, 15);
            Animal herbivore = returnNewAnimal(animalType);

                    locations[ThreadLocalRandom.current().nextInt(WIDTH)]
                            [ThreadLocalRandom.current().nextInt(HEIGHT)]
                            .addAnimalToLocation(herbivore);
        }
        Plant.multiply();

    }

    public void print() {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                System.out.print(locations[i][j]);
            }
            System.out.println();
        }
    }
}

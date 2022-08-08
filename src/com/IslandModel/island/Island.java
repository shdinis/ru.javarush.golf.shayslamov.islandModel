package com.IslandModel.island;

import com.IslandModel.entities.animals.Animal;
import com.IslandModel.entities.plants.Plant;


import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import static com.IslandModel.island.Configurations.*;
import static com.IslandModel.island.Location.returnNewAnimal;


public final class Island {

    //    public static final Location[][] locations = new Location[WIDTH][HEIGHT];
    public final HashMap<Coordinates, Location> locations = new HashMap<>();

    public void initialize() {
        for (int ix = 0; ix < WIDTH; ix++) {
            for (int iy = 0; iy < HEIGHT; iy++) {
                locations.put(Coordinates.newCoordinates(ix, iy), new Location(ix, iy));
            }
        }
    }

    public void initializeAnimal() {
        int maxCountPredators = 5;
        int maxCountHerbivores = 10;

        for (int i = 0; i < maxCountPredators; i++) {
            int animalType = ThreadLocalRandom.current().nextInt(0, 5);
            Animal predator = returnNewAnimal(animalType);

            locations.get(Coordinates.newCoordinates(ThreadLocalRandom.current().nextInt(WIDTH),
                            ThreadLocalRandom.current().nextInt(HEIGHT)))
                    .addAnimalToLocation(predator);
        }

        for (int i = 0; i < maxCountHerbivores; i++) {
            int animalType = ThreadLocalRandom.current().nextInt(5, 15);
            Animal herbivore = returnNewAnimal(animalType);

            locations.get(Coordinates.newCoordinates(ThreadLocalRandom.current().nextInt(WIDTH),
                            ThreadLocalRandom.current().nextInt(HEIGHT)))
                    .addAnimalToLocation(herbivore);
        }
//        Plant.multiply();
        for (int ix = 0; ix < WIDTH; ix++) {
            for (int iy = 0; iy < HEIGHT; iy++) {

                int amountPlantToLocation = locations.get(Coordinates.newCoordinates(ix, iy)).getPlantsSizeToLocation();
                if (amountPlantToLocation == 0 && ThreadLocalRandom.current().nextBoolean()) {//создаст с шансом 50% новые растения
                    for (int i = 0; i < 2; i++) {
                        locations.get(Coordinates.newCoordinates(ix, iy)).addPlantToLocation(new Plant());
                    }
                } else {
                    for (int i = 0; i < amountPlantToLocation; i++) {
                        locations.get(Coordinates.newCoordinates(ix, iy)).addPlantToLocation(new Plant());
                    }
                }
            }
        }

    }

    public void print() {
        for (int ix = 0; ix < WIDTH; ix++) {
            for (int iy = 0; iy < HEIGHT; iy++) {
                System.out.println(ix + ", " + iy + " " + locations.get(Coordinates.newCoordinates(ix, iy)));
            }
        }

//        for (int i = 0; i < locations.length; i++) {
//            for (int j = 0; j < locations[i].length; j++) {
//                System.out.print(locations[i][j]);
//            }
//            System.out.println();
//        }
    }
}

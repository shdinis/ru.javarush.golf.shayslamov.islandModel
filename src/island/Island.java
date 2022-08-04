package island;

import animals.Animal;
import animals.herbivores.*;
import animals.predators.*;


import java.util.concurrent.ThreadLocalRandom;

import static island.Configurations.*;


public class Island {

    Location[][] locations = new Location[WIDTH][HEIGHT];

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
            Animal predator = switch (animalType) {
                case 0 -> new Bear();
                case 1 -> new Boa();
                case 2 -> new Eagle();
                case 3 -> new Fox();
                default -> new Wolf();
            };
            locations[ThreadLocalRandom.current().nextInt(WIDTH)]
                    [ThreadLocalRandom.current().nextInt(HEIGHT)]
                    .addAnimalToLocation(predator);
        }

        for (int i = 0; i < maxCountHerbivores; i++) {
            int animalType = ThreadLocalRandom.current().nextInt(5, 15);
            Animal herbivore = switch (animalType) {
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
            locations[ThreadLocalRandom.current().nextInt(WIDTH)]
                    [ThreadLocalRandom.current().nextInt(HEIGHT)]
                    .addAnimalToLocation(herbivore);
        }


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

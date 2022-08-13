package com.islandmodel.island;

import com.islandmodel.island.location.Coordinate;
import com.islandmodel.island.location.Location;
import com.islandmodel.utils.Randomizer;

import java.util.ArrayList;

import static com.islandmodel.Config.*;

public class Island {

    //    public final HashMap<Coordinate, Location> locations = new HashMap<>();
    private final Location[][] locations;

    public Island(int cols,int rows) {
        this.locations = new Location[cols][rows];
    }

    public Location[][] getLocations() {
        return locations;
    }



//    public Island() {
//        this.locations = new Location[COLS][ROWS];
//        for (int cols = 0; cols < COLS; cols++) {
//            for (int rows = 0; rows < ROWS; rows++) {
//                locations[cols][rows] = new Location(cols, rows);
//            }
//        }
//    }
//
//    public void initializeNearbyLocation(){
//        for (int col = 0; col < COLS; col++) {
//            for (int row = 0; row < ROWS; row++) {
//                ArrayList<Location> result = new ArrayList<>();
//                if (0 < col) {
//                    result.add(locations(col - 1, row));
//                }
//                if (0 < col && 0 < row) {
//                    result.add(Coordinate.newCoordinate(col - 1, row - 1));
//                }
//                if (0 < row) {
//                    result.add(Coordinate.newCoordinate(col, row - 1));
//                }
//                if (col < COLS - 1 && 0 < row) {
//                    result.add(Coordinate.newCoordinate(col + 1, row - 1));
//                }
//                if (col < COLS - 1) {
//                    result.add(Coordinate.newCoordinate(col + 1, row));
//                }
//                if (col < COLS - 1 && row < ROWS - 1) {
//                    result.add(Coordinate.newCoordinate(col + 1, row + 1));
//                }
//                if (row < ROWS - 1) {
//                    result.add(Coordinate.newCoordinate(col, row + 1));
//                }
//                if (0 < col && row < ROWS - 1) {
//                    result.add(Coordinate.newCoordinate(col - 1, row + 1));
//                }
//                locations[col][row].setNearbyLocations(result);
//            }
//        }
//    }
//
//
//    public void initialize() {
//        for (int typeOfAnimalToCreate = 0; typeOfAnimalToCreate < ENTITIES_INITIAL_QUANTITY.length; typeOfAnimalToCreate++) {//перебираем виды животных
//            for (int quantity = 0; quantity < ENTITIES_INITIAL_QUANTITY[typeOfAnimalToCreate]; quantity++) {
//                int randomCol = Randomizer.getRandom(COLS);
//                int randomRow = Randomizer.getRandom(ROWS);
//                locations[randomCol][randomRow].initializeAnimal(typeOfAnimalToCreate);
//            }
//        }
//    }
//
//    public void initializeAnimal() {


//        for (Location[] locations : locationArray) {
//            for (Location location : locations) {
//                location.initializeAnimal();
//            }
//        }


//        locations.forEach((coordinate, location) -> initializeAnimal());


//        int maxCountPredators = 5;
//        int maxCountHerbivores = 10;
//
//        for (int i = 0; i < maxCountPredators; i++) {
//            int animalType = getRandom(5);
//            Animal predator = returnNewAnimal(animalType);
//
//            locations.get(Coordinate.newCoordinate(ThreadLocalRandom.current().nextInt(WIDTH),
//                            ThreadLocalRandom.current().nextInt(HEIGHT)))
//                    .addAnimalToLocation(predator);
//        }
//
//        for (int i = 0; i < maxCountHerbivores; i++) {
//            int animalType = getRandom(5, 15);
//            Animal herbivore = returnNewAnimal(animalType);
//            locations.get(newCoordinate(getRandom(WIDTH), getRandom(HEIGHT))).addAnimalToLocation(herbivore);
//        }
//
//        for (int ix = 0; ix < WIDTH; ix++) {
//            for (int iy = 0; iy < HEIGHT; iy++) {
//
//                int amountPlantToLocation = locations.get(newCoordinate(ix, iy)).getPlantsSizeToLocation();
//                if (amountPlantToLocation == 0) {
//                    for (int i = 0; i < 20; i++) {
//                        locations.get(Coordinate.newCoordinate(ix, iy)).addPlantToLocation(new Plant());
//                    }
//                } else {
//                    for (int i = 0; i < amountPlantToLocation; i++) {
//                        locations.get(Coordinate.newCoordinate(ix, iy)).addPlantToLocation(new Plant());
//                    }
//                }
//            }
//        }
    }

    public void print() {
        System.out.println("=".repeat(200));
        for (Location[] locations : locations) {
            for (Location location : locations) {
                location.toString();
                System.out.println();
            }
        }
    }
}

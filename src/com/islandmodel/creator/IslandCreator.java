package com.islandmodel.creator;

import com.islandmodel.island.Island;
import com.islandmodel.island.location.Coordinate;
import com.islandmodel.island.location.Location;
import com.islandmodel.utils.Randomizer;

import java.util.ArrayList;

import static com.islandmodel.Config.*;
import static com.islandmodel.Config.ROWS;

public class IslandCreator {

    public Island IslandCreator() {
        Island island = new Island(COLS, ROWS);
        createLocations(island);

        island.initializeAnimal();

        return island;

    }

    private void createLocations(Island island) {
        Location[][] locations = island.getLocations();

        for (int col = 0; col < locations.length; col++) {
            for (int row = 0; row < locations[col].length; row++) {
                locations[col][row] = new Location(col, row);
            }
        }
    }

    public void findNearbyLocations() {
        for (int col = 0; col < COLS; col++) {
            for (int row = 0; row < ROWS; row++) {
                ArrayList<Location> result = new ArrayList<>();
                if (0 < col) {
                    result.add(locations(col - 1, row));
                }
                if (0 < col && 0 < row) {
                    result.add(Coordinate.newCoordinate(col - 1, row - 1));
                }
                if (0 < row) {
                    result.add(Coordinate.newCoordinate(col, row - 1));
                }
                if (col < COLS - 1 && 0 < row) {
                    result.add(Coordinate.newCoordinate(col + 1, row - 1));
                }
                if (col < COLS - 1) {
                    result.add(Coordinate.newCoordinate(col + 1, row));
                }
                if (col < COLS - 1 && row < ROWS - 1) {
                    result.add(Coordinate.newCoordinate(col + 1, row + 1));
                }
                if (row < ROWS - 1) {
                    result.add(Coordinate.newCoordinate(col, row + 1));
                }
                if (0 < col && row < ROWS - 1) {
                    result.add(Coordinate.newCoordinate(col - 1, row + 1));
                }
                locations[col][row].setNearbyLocations(result);
            }
        }
    }


    public void initialize() {
        for (int typeOfAnimalToCreate = 0; typeOfAnimalToCreate < ENTITIES_INITIAL_QUANTITY.length; typeOfAnimalToCreate++) {//перебираем виды животных
            for (int quantity = 0; quantity < ENTITIES_INITIAL_QUANTITY[typeOfAnimalToCreate]; quantity++) {
                int randomCol = Randomizer.getRandom(COLS);
                int randomRow = Randomizer.getRandom(ROWS);
                locations[randomCol][randomRow].initializeAnimal(typeOfAnimalToCreate);
            }
        }
    }

    public void initializeAnimal() {


    }
}

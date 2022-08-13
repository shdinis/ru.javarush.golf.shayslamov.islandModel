package com.islandmodel.creator;

import com.islandmodel.island.Island;
import com.islandmodel.island.Location;
import com.islandmodel.utils.Randomizer;

import java.util.ArrayList;

import static com.islandmodel.Config.*;

public class IslandCreator {

    public Island creatorIsland() {
        Island island = new Island(COLS, ROWS);
        createLocations(island);
        findNearbyLocations(island);
        initializeAnimal(island);
        return island;

    }

    private void createLocations(Island island) {
        Location[][] locations = island.getLocations();

        for (int col = 0; col < locations.length; col++) {
            for (int row = 0; row < locations[col].length; row++) {
                locations[col][row] = new Location();
            }
        }
    }

    private void findNearbyLocations(Island island) {
        Location[][] locations = island.getLocations();

        for (int col = 0; col < locations.length; col++) {
            for (int row = 0; row < locations[col].length; row++) {
                ArrayList<Location> result = new ArrayList<>();
                if (0 < col) {
                    result.add(locations[col - 1][row]);
                }
                if (0 < row) {
                    result.add(locations[col][row - 1]);
                }
                if (col < locations.length - 1) {
                    result.add(locations[col + 1][row]);
                }
                if (row < locations[col].length - 1) {
                    result.add(locations[col][row + 1]);
                }
                locations[col][row].setNearbyLocations(result);
            }
        }
    }


    private void initializeAnimal(Island island) {
        Location[][] locations = island.getLocations();

        for (int typeOfEntitieToCreate = 0; typeOfEntitieToCreate < ENTITIES_INITIAL_QUANTITY.length; typeOfEntitieToCreate++) {//перебираем виды животных
            for (int quantity = 0; quantity < ENTITIES_INITIAL_QUANTITY[typeOfEntitieToCreate]; quantity++) {
                int randomCol = Randomizer.getRandom(COLS);
                int randomRow = Randomizer.getRandom(ROWS);
                locations[randomCol][randomRow].addEntityToLocation(typeOfEntitieToCreate);
            }
        }
    }


}

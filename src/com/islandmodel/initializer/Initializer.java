package com.islandmodel.initializer;

import com.islandmodel.creator.IslandCreator;
import com.islandmodel.island.Island;

public class Initializer {

    public Island createIsland() {
        IslandCreator islandCreator = new IslandCreator();
        return islandCreator.creatorIsland();
    }
}

package com.islandmodel.GameWorker;

import com.islandmodel.creator.IslandCreator;
import com.islandmodel.island.Island;

public class Game extends Thread{
private final Island island;

    public Game(Island island) {
        this.island = island;
    }

    @Override
    public void run() {
        super.run();
    }
}

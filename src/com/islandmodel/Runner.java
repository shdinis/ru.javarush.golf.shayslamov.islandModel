package com.islandmodel;

import com.islandmodel.GameWorker.Game;
import com.islandmodel.initializer.Initializer;
import com.islandmodel.island.Island;

public class Runner {
    public static void main(String[] args) {
        Initializer initializer = new Initializer();
        Island island = initializer.createIsland();
        island.print();
        Game game = new Game(island);


    }
}

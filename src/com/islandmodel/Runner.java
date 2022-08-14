package com.islandmodel;

import com.islandmodel.gameworker.Game;
import com.islandmodel.gameworker.GameWorker;
import com.islandmodel.initializer.Initializer;
import com.islandmodel.island.Island;

public class Runner {
    public static void main(String[] args) {
        Initializer initializer = new Initializer();
        Island island = initializer.createIsland();
        island.showStatistic(island.getDay());
        Game game = new Game(island);
        GameWorker gameWorker = new GameWorker(game);
        gameWorker.start();
    }
}

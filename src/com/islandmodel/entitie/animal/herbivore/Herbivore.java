package com.islandmodel.entitie.animal.herbivore;

import com.islandmodel.entitie.animal.Animal;
import com.islandmodel.entitie.EntitieType;
import com.islandmodel.island.location.Coordinate;
import com.islandmodel.island.location.EntitiesToLocation;

import java.util.ArrayList;

public class Herbivore extends Animal {
    public Herbivore(EntitieType type) {
        super(type);
    }

    @Override
    public void eat(EntitiesToLocation menuEntitiesToLocation) {
        for (int i = 0; i < menuEntitiesToLocation.getPlants().size(); i++) {
                menuEntitiesToLocation.getPlants().get(i).setBitten();

                setSaturation(menuEntitiesToLocation.getPlants().get(i).getWeight()); //вес жертвы должен перейти в желудок поедателя и все(т.к. среди нас нет падьщиков)

        }
    }

    @Override
    public Coordinate chooseDirection(ArrayList<Coordinate> coordinateToMove) {



        return null;
    }

//    @Override
//    public Coordinates chooseDirection(ArrayList<Coordinates> coordinatesToMove) {
//        int randomCoordinates = ThreadLocalRandom.current().nextInt(coordinatesToMove.size());
//        return coordinatesToMove.get(randomCoordinates);
//    }


}

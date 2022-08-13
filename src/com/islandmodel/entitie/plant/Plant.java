package com.islandmodel.entitie.plant;

//import static com.IslandModel.island.Configurations.*;

import com.islandmodel.entitie.Entitie;
import com.islandmodel.entitie.EntitieType;

public class Plant extends Entitie {

    public static final int MAX_COUNT_IN_LOCATION = 200;

    public Plant() {
        super(EntitieType.PLANTS);
    }

//    public boolean isBitten() {
//        return bitten;
//    }

//    public void setBitten() {
//        this.bitten = true;
//    }

//    public static void multiply() {
//        for (int ix = 0; ix < WIDTH; ix++) {
//            for (int iy = 0; iy < HEIGHT; iy++) {
//
//                int amountPlantToLocation = locations.get(Coordinates.newCoordinates(ix,iy)).getPlantsSizeToLocation();
//                if (amountPlantToLocation == 0 && ThreadLocalRandom.current().nextBoolean()) {//создаст с шансом 50% новые растения
//                    for (int i = 0; i < 2; i++) {
//                        locations.get(Coordinates.newCoordinates(ix,iy)).addPlantToLocation(new Plant());
//                    }
//                } else {
//                    for (int i = 0; i < amountPlantToLocation; i++) {
//                        locations.get(Coordinates.newCoordinates(ix,iy)).addPlantToLocation(new Plant());
//                    }
//                }
//            }
//        }
//    }

    @Override
    public String toString() {
        return "\uD83C\uDF3F";
    }

}

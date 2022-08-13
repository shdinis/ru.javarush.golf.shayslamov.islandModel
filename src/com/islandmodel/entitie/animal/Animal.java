package com.islandmodel.entitie.animal;

import com.islandmodel.entitie.EntitieType;
import com.islandmodel.Config;
import com.islandmodel.entitie.Entitie;
import com.islandmodel.island.location.Coordinate;
import com.islandmodel.island.location.EntitiesToLocation;

import java.util.ArrayList;

public abstract class Animal extends Entitie {

    private int saturation = 0;//насыщение
    private boolean canMoved = true;// под вопросом надо ли

    public void itIsNewDay() {
        this.canMoved = true;
        saturation = 0;
    }

    public void CanMoved() {
        this.canMoved = false;
    }

    public boolean isCanMoved() {
        return canMoved;
    }

    protected Animal(EntitieType type) {
        super(type);
    }


//    public int getWeight() {
//        return weight;
//    }
//
//    public void setWeight(int weight) {
//        this.weight = weight;
//    }


    public abstract void eat(EntitiesToLocation menuEntitiesToLocation);



    public void setSaturation(int saturation) {
        this.saturation = Math.min(this.saturation + saturation, Config.MAX_SATURATION[this.getType().ordinal()]);
    }

    //
//    public abstract void multiply();//breed
//
    public abstract Coordinate chooseDirection(ArrayList<Coordinate> coordinateToMove);

}


package com.IslandModel.entities.animals;

import com.IslandModel.island.Entities;

public abstract class Animal {

    protected int x;
    protected int y;
    public final TypesOfAnimals type;
    private int weight;
    private boolean isDead = false;
    private int saturation = 0;//насыщение
    private boolean canMoved = true;



    protected Animal(TypesOfAnimals type) {
        this.type = type;
        this.weight = Matrix.ANIMAL_WEIGHT[type.ordinal()];

    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead() {
        isDead = true;
    }


    public abstract void eat(Entities menuEntities);

    public boolean onTheMenu(Animal animal) {
        return Matrix.CHANCES_TO_EAT[this.type.ordinal()][animal.type.ordinal()] != 0;
    }

    public void setSaturation(int saturation) {
        this.saturation = Math.min(this.saturation + saturation, Matrix.MAX_SATURATION[this.type.ordinal()]);
    }

//
//    public abstract void multiply();//breed
//
//    public abstract void chooseDirection();
}


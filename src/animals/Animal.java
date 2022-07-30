package animals;

import island.Coordinate;

public abstract class Animal {

    protected int x;
    protected int y;

    private int weight = 0;
    private boolean isDead = false;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }




    public abstract void eat();

    public abstract void multiply();//breed

    public abstract void chooseDirection();
}


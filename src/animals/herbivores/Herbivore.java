package animals.herbivores;

import animals.Animal;
import plants.Plant;

import java.util.List;

public abstract class Herbivore extends Animal {

    protected int weight = 0;
    protected boolean isDead = false;


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

    public abstract void eat(List<Plant> plants);

}

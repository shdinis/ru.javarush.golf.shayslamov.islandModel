package animals.predators;

import animals.Animal;
import animals.TypesOfAnimals;
import animals.herbivores.*;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Wolf extends Predator {

    private int saturation = 0;//насыщение
    public static final int MAX_SATURATION =  800;

    @Override
    public void multiply() {

    }

    @Override
    public void chooseDirection() {

    }

    @Override
    public void eat(List<Herbivore> herbivores) {
        for (Herbivore herbivore : herbivores) {
            if ((herbivore instanceof Boar)) {
                int random = ThreadLocalRandom.current().nextInt(100);
                if (random < 15) {
                    if(this.getSaturation()<MAX_SATURATION){
                        if (herbivore.getWeight()>MAX_SATURATION){
                            this.setSaturation(MAX_SATURATION);
                            herbivore.setDead(false);
                        }else{
                            this.setSaturation(herbivore.getWeight());
                            herbivore.setDead(false);
                        }
                    }
                }
//            } else if (herbivore instanceof Buffalo) {
//
//            } else if (herbivore instanceof Caterpillar) {
//
//            } else if (herbivore instanceof Deer) {
//
//            } else if (herbivore instanceof Duck) {
//
//            } else if (herbivore instanceof Goat) {
//
//            } else if (herbivore instanceof Horse) {
//
//            } else if (herbivore instanceof Mouse) {
//
//            } else if (herbivore instanceof Rabbit) {
//
//            } else if (herbivore instanceof Sheep) {
//
            }
        }
    }

    public int getSaturation() {
        return saturation;
    }

    public void setSaturation(int saturation) {
        this.saturation = saturation;
    }
}

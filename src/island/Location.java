package island;

import animals.herbivores.Herbivore;
import animals.predators.Predator;
import plants.Plant;

import java.util.List;
import java.util.ArrayList;

public class Location {

    // Списки где будут хранитсья находящиеся на локации сущности
    List<Herbivore> herbivores = new ArrayList<>();
    List<Predator> predators = new ArrayList<>();
    List<Plant> plants = new ArrayList<>();

    public void calculate(){

        for (int i = 0; i < predators.size(); i++) {
            Predator predator = predators.get(i);
            predator.eat(herbivores);


            //размножаемся
            predator.multiply();

            //перемещаемся
            predator.chooseDirection();

        }

        for (int i = 0; i < herbivores.size(); i++) {
            Herbivore herbivore = herbivores.get(i);
            herbivore.eat(plants);

            herbivore.multiply();

            herbivore.chooseDirection();
        }
    }

    public String toString(){
        return " | | ";
    }
}

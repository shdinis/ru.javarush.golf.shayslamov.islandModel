package com.islandmodel.gameworker;

import com.islandmodel.entity.Entity;
import com.islandmodel.entity.animal.Animal;
import com.islandmodel.island.Location;

public class Task {

    private final Entity entity;
    private final Location location;

    public Task(Entity entity, Location location) {
        this.entity = entity;
        this.location = location;
    }

    public void perform() {
        if (entity instanceof Animal animal) {
            if (animal.eat(location)) {
                animal.multiply(location);
            }
            animal.move(location);
        } else {
            entity.multiply(location);
        }
    }
}

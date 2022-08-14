package com.islandmodel.gameworker;

import com.islandmodel.entity.Entity;
import com.islandmodel.island.Island;
import com.islandmodel.island.Location;

import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class EntityWorker implements Runnable {
    private final int entityType;
    private final Island island;
    private final Queue<Task> tasks = new ConcurrentLinkedQueue<>();

    public EntityWorker(Integer entityType, Island island) {
        this.entityType = entityType;
        this.island = island;
    }

    @Override
    public void run() {
        Location[][] locations = island.getLocations();
        for (Location[] rows : locations) {
            for (Location location : rows) {
                createTasksForLocation(location);
             }
        }
    }

    private void createTasksForLocation(Location location) {
        Set<Entity> entities = location.getOneTypeOfEntitiesToLocation(entityType);
        if (entities != null) {
            location.getLock().lock();
            try {
                for (Entity entity : entities) {
                    tasks.add(new Task(entity, location));
                }
            } finally {
                location.getLock().unlock();
            }
        }

        tasks.forEach(Task::perform);
        tasks.clear();
    }
}

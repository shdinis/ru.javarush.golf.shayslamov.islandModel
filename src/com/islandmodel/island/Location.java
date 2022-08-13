package com.islandmodel.island;

import com.islandmodel.entity.Entity;
import com.islandmodel.entity.EntityType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class Location {

    private final Map<Integer, ArrayList<Entity>> entitiesToLocation;
    private final ArrayList<Location> nearbyLocations;

    private ReentrantLock lock = new ReentrantLock();

    public Location() {
        this.entitiesToLocation = new HashMap<>();
        initializeMapEntitiesToLocation();
        this.nearbyLocations = new ArrayList<>();
    }

    private void initializeMapEntitiesToLocation() {
        for (int i = 0; i < EntityType.values().length; i++) {
            entitiesToLocation.put(i, new ArrayList<>());
        }
    }

    public void clearingMapEntitiesToLocation(){
        for (Map.Entry<Integer, ArrayList<Entity>> entry : entitiesToLocation.entrySet()) {
            entry.getValue().removeIf(Entity::isRemovable);
        }
    }

    public ArrayList<Location> getNearbyLocations() {
        return nearbyLocations;
    }

    public void setNearbyLocations(ArrayList<Location> nearbyLocations) {
        this.nearbyLocations.addAll(nearbyLocations);
    }

    public ArrayList<Entity> getOneTypeOfEntitiesToLocation(int typeOfEntityToLocation) {
        return entitiesToLocation.get(typeOfEntityToLocation);
    }

    public void addEntityToLocation(int typeOfEntityToCreate) {
        entitiesToLocation.get(typeOfEntityToCreate).add(Entity.returnNewEntity(typeOfEntityToCreate));
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public String toString() {
        String result = "";
        for (Map.Entry<Integer, ArrayList<Entity>> entry : entitiesToLocation.entrySet()) {
            System.out.print(EntityType.values()[entry.getKey()]+"="+ entry.getValue().size()+" ");
        }
        return result;
    }
}

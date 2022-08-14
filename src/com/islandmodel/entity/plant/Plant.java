package com.islandmodel.entity.plant;

import com.islandmodel.Config;
import com.islandmodel.entity.Entity;
import com.islandmodel.entity.EntityType;
import com.islandmodel.island.Location;

public class Plant extends Entity {

    public Plant() {
        super(EntityType.PLANTS);
    }

    @Override
    public void multiply(Location currentLocation) {
        safeMultiply(currentLocation);
    }

    @Override
    public boolean eat(Location currentLocation) {
        // Do nothing
        return false;
    }

    @Override
    public void move(Location currentLocation) {
        // Do nothing
    }

    private void safeMultiply(Location currentLocation) {
        currentLocation.getLock().lock();
        try {
            int plantsToLocationQuantity = currentLocation.getOneTypeOfEntitiesToLocation(getType().ordinal()).size();
            int maxQuantityInLocation = Config.MAX_PER_LOCATION[getType().ordinal()];
            if (plantsToLocationQuantity < maxQuantityInLocation) {
                currentLocation.addEntityToLocation(getType().ordinal());
            }
        } finally {
            currentLocation.getLock().unlock();
        }
    }
}

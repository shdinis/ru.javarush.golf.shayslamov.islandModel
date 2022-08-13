package com.islandmodel.island;

public class Island {

    private final Location[][] locations;

    public Island(int cols, int rows) {
        this.locations = new Location[cols][rows];
    }

    public Location[][] getLocations() {
        return locations;
    }

    public void print() {
        System.out.println("=".repeat(200));
        for (int col = 0; col < locations.length; col++) {
            for (int row = 0; row < locations[col].length; row++) {
                System.out.print("[" + col + "," + row + "] ");
                locations[col][row].toString();
                System.out.println();
            }

        }
    }
}

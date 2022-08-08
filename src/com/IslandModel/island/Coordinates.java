package com.IslandModel.island;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Coordinates {
    private static HashSet<Coordinates> coordinatePull = new HashSet<>();
    private final int x;
    private final int y;

    public static Coordinates newCoordinates(int coordinatesX, int coordinatesY) {
        Coordinates resultNew = new Coordinates(coordinatesX, coordinatesY);
        for (Coordinates coordinates : coordinatePull) {
            if (coordinates.equals(resultNew)){
                return coordinates;
            }
        }
        return resultNew;
    }

    private Coordinates(int coordinatesX, int coordinatesY) {
        if (0 < coordinatesX && coordinatesX < Configurations.WIDTH) {
            this.x = coordinatesX;
        } else {
            this.x = coordinatesX % Configurations.WIDTH;
        }
        if (0 < coordinatesY && coordinatesY < Configurations.HEIGHT) {
            this.y = coordinatesY;
        } else {
            this.y = coordinatesY % Configurations.HEIGHT;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "\n" + x +
                ", " + y+
                "";
    }

    public static void main(String[] args) {
        HashMap<Coordinates, String> result = new HashMap<>();

        Coordinates c1 = new Coordinates(2, 1);
        Coordinates c2 = new Coordinates(1, 2);

        result.put(c1, "Координата 1");
        result.put(c2, "Координата 2");

        System.out.println(result);


    }
}

package com.islandmodel.island.location;

import java.util.HashSet;
import java.util.Objects;

/*
 *Ненужен т.к. мы локации будем хранить в массиве
 */
public class Coordinate {
    private static HashSet<Coordinate> coordinatePull = new HashSet<>();

    private final int col;//x
    private final int row;//y


    //тут кусок кода где типа создавался пулл координат и оттуда подтягивался готовый результат
    public static Coordinate newCoordinate(int col, int row) {
        for (Coordinate coordinate : coordinatePull) {
            if (coordinate.getCol() == col && coordinate.getRow() == row) {
                return coordinate;
            }
        }
        return new Coordinate(col, row);
    }

    private Coordinate(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return col == that.col && row == that.row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(col, row);
    }

    @Override
    public String toString() {
        return "[" + col + ", " + row + "]";
    }

//    public static void main(String[] args) {
//        HashMap<Coordinate, String> result = new HashMap<>();
//
//        Coordinate c1;
//        Coordinate c2;
//        c1= newCoordinate(10, 2);
//        c2= newCoordinate(1, 2);
//        System.out.println(c1==c2);
//
//        System.out.println(c1);
//        System.out.println(c2);
//
//        result.put(c1, "Координата 1");
//        result.put(c2, "Координата 2");
//
//        System.out.println(result);
//
//
//    }
}

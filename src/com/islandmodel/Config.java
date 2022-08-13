package com.islandmodel;

public final class Config {
    public static final int COLS = 1;//x
    public static final int ROWS = 1;//y

    public static final int[][] CHANCES_TO_EAT = {
            //[BEAR, BOA, EAGLE, FOX, WOLF, BOAR, BUFFALO, CATERPILLAR, DEER, DUCK, GOAT, HORSE, MOUSE, RABBIT, SHEEP, PLANTS
            {0, 80, 0, 0, 0, 40, 80, 80, 90, 70, 70, 50, 20, 10, 0, 0},
            {0, 0, 15, 0, 0, 0, 0, 20, 40, 0, 0, 0, 0, 10, 0, 0},
            {0, 0, 10, 0, 0, 0, 0, 90, 90, 0, 0, 0, 0, 80, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 70, 90, 0, 0, 0, 0, 60, 40, 0},
            {0, 0, 0, 0, 0, 10, 15, 60, 80, 60, 70, 15, 10, 40, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 50, 0, 0, 0, 0, 0, 90, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    //[BEAR, BOA, EAGLE,   FOX,   WOLF,  BOAR,  BUFFALO, CATERPILLAR, DEER, DUCK, GOAT, HORSE, MOUSE, RABBIT, SHEEP, PLANTS
    public static final int[] ENTITY_WEIGHT = {500000, 15000, 6000, 8000, 50000, 400000, 700000, 10, 300000, 1000, 60000, 400000, 50, 2000, 70000, 1000};
    public static final double[] ANIMAL_WEIGHT1 = {5000.0, 150.0, 60.0, 80.0, 500.0, 4000.0, 7000.0, 0.1, 3000.0, 10.0, 600.0, 4000.0, 0.5, 20.0, 700.0, 10.0};
    public static final int[] MAX_SATURATION = {80000, 3000, 1000, 2000, 8000, 50000, 100000, 0, 50000, 150, 10000, 60000, 10, 450, 15000, 0};
    public static final double[] MAX_SATURATION1 = {800.0, 30.0, 10.0, 20.0, 80.0, 500.0, 1000.0, 0, 500.0, 1.5, 100.0, 600.0, 0.1, 4.5, 150.0, 0.0};
    public static final int[] TRAVEL_DISTANCE = {2, 1, 3, 2, 3, 2, 3, 0, 4, 4, 3, 4, 1, 2, 3, 0};
    public static final int[] MAX_PER_LOCATION = {5, 30, 20, 30, 30, 50, 10, 1000, 20, 200, 140, 20, 500, 150, 140, 200};
    public static final int[] ENTITIES_INITIAL_QUANTITY = {2, 5, 5, 5, 5, 3, 5, 200, 7, 50, 20, 5, 100, 10, 10, 200};
//    public int maxAmountInCell;//максимальное количество
//    public int moveSpeed;
//    public int eatingWeight;

    public static void main(String[] args) {
        System.out.println(MAX_PER_LOCATION.length);
        System.out.println(ENTITIES_INITIAL_QUANTITY.length);
    }
}

package com.islandmodel.utils;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {

    public static int getRandom(int to) {
        return ThreadLocalRandom.current().nextInt(to);
    }

    public static int getRandom(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to);
    }

    public static boolean getRandomBoolean(int chance) {
        return chance / 100 <= getRandom(100);
    }
}

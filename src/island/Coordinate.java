package island;

import java.util.concurrent.ThreadLocalRandom;

import static island.Configurations.*;

public class Coordinate {
    private int x;
    private int y;


    public Coordinate(int x, int y) {
        this.x = (0 <= x && x < WIDTH) ? x : -1;
        this.y = (0 <= y && y < HEIGHT) ? y : -1;
    }

    public Coordinate() {
        this.x = ThreadLocalRandom.current().nextInt(WIDTH);
        this.y = ThreadLocalRandom.current().nextInt(HEIGHT);
    }
}

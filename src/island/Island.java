package island;

import static island.Configurations.HEIGHT;
import static island.Configurations.WIDTH;

public class Island {

    Location[][] locations = new Location[WIDTH][HEIGHT];

    public void initialize(){
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j] = new Location();
            }
        }
    }

    public void print(){
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                System.out.print(locations[i][j]);
            }
            System.out.println();
        }
    }
}

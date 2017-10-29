package minesweeper;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author LebedenkoN
 */
public class CoordinateGenerator {

    private ArrayList<Coordinate> coordinates;

    public CoordinateGenerator() {
        this.coordinates = new ArrayList<>();
    }

    private boolean coordinateExists(int x, int y) {
        for (Coordinate coordinate : this.coordinates) {
            if (coordinate.equals(new Coordinate(x, y))) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Coordinate> generateCoordinates(int to, int amount) {

        Random r = new Random();

        for (int i = 0; i < amount; i++) {

            int x;
            int y;

            do {
                x = r.nextInt(to);
                y = r.nextInt(to);
            } while (this.coordinateExists(x, y));

            coordinates.add(new Coordinate(x, y));
        }

        return this.coordinates;

    }

}

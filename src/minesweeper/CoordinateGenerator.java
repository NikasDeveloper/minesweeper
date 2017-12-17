package minesweeper;

import minesweeper.utilities.Generatable;
import java.util.Random;
import java.util.ArrayList;

/**
 * @author LebedenkoN
 */
public class CoordinateGenerator implements Generatable {

    private ArrayList<Coordinate> coordinates;

    public CoordinateGenerator() {
        this.coordinates = new ArrayList<>();
    }

    private boolean coordinateExists(int x, int y) {
        for (Coordinate coordinate : this.coordinates) if (coordinate.equals(new Coordinate(x, y))) return true;
        return false;
    }

    @Override
    public ArrayList<Coordinate> generateCoordinates(int to, int amount) {

        Random r = new Random();

        for (int i = 0; i < amount; i++) {

            int x, y;

            do {
                x = r.nextInt(to);
                y = r.nextInt(to);
            } while (this.coordinateExists(x, y));

            coordinates.add(new Coordinate(x, y));

        }

        return this.coordinates;

    }

}

package minesweeper.utilities;

import minesweeper.Coordinate;
import java.util.ArrayList;

public interface Generatable {
    public ArrayList<Coordinate> generateCoordinates(int to, int amount);
}

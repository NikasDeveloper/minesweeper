package minesweeper;

import java.util.ArrayList;

public class MinePlanter {

    private int size;
    private int toPlant;
    private CoordinateGenerator generator;
    private ArrayList<Coordinate> coordinates;

    public MinePlanter(int size, int toPlant) {
        this.size = size;
        this.toPlant = toPlant;
        this.generator = new CoordinateGenerator();
        this.coordinates = new ArrayList<>();
    }

    private void setCoordinates(){
        this.coordinates = generator.generateCoordinates(size, toPlant);
    }

    public void plantMines(StageCell[][] cells){
        this.setCoordinates();
        for (Coordinate coordinate : coordinates) cells[coordinate.getX()][coordinate.getY()].setMine(true);
    }
}

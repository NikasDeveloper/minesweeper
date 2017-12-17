package minesweeper;

import java.util.ArrayList;

/**
 * @author LebedenkoN
 */
public class Stage {

    private final int STAGE_SIZE = 20;
    private final int TOTAL_MINES = 50;
    private StageCell[][] cells;

    public Stage() {
        this.cells = new StageCell[STAGE_SIZE][STAGE_SIZE];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new StageCell(new Coordinate(i, j));
            }
        }
    }

    public int getStageSize() {
        return STAGE_SIZE;
    }

    public int getTotalMines() {
        return TOTAL_MINES;
    }

    public StageCell[][] getCells() {
        return cells;
    }

    public ArrayList<StageCell> getCellNeighbours(int x, int y){

        ArrayList<StageCell> neighbours = new ArrayList<>();

        for(int xOffset = -1; xOffset <= 1; xOffset++){

            int i = x + xOffset;
            if(i < 0 || i >= STAGE_SIZE) continue;

            for(int yOffset = -1; yOffset <= 1; yOffset++){
                int j = y + yOffset;
                if(j < 0 || j >= STAGE_SIZE) continue;
                neighbours.add(cells[i][j]);
            }

        }

        return neighbours;
    }

}
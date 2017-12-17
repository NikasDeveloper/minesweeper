/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

/**
 * @author LebedenkoN
 */
public class MineCalculator {

    private int calculateMinesAround(int x, int y, Stage stage) {
        int mineCounter = 0;
        for (StageCell cell : stage.getCellNeighbours(x, y)) if (cell.isMine()) mineCounter++;
        return mineCounter;
    }

    public void setMineCounter(Stage stage) {

        StageCell[][] cells = stage.getCells();

        for (int i = 0; i < cells.length; i++)
            for (int j = 0; j < cells[i].length; j++)
                cells[i][j].setMinesAround(this.calculateMinesAround(cells[i][j].getX(), cells[i][j].getY(), stage));

    }

}

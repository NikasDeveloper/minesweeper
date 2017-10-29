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

    public static int calculateMinesAround(Coordinate coordinate, StageCell[][] cells) {

        int mineCounter = 0;
        int x = coordinate.getX();
        int y = coordinate.getY();

        // TODO REFACTOR
        if (x > 0 && y > 0 && cells[x - 1][y - 1].isMine()) {
            mineCounter++;
        }

        if (y > 0 && cells[x][y - 1].isMine()) {
            mineCounter++;
        }

        if (x < cells.length - 1 && y > 0 && cells[x + 1][y - 1].isMine()) {
            mineCounter++;
        }

        if (x < cells.length - 1 && cells[x + 1][y].isMine()) {
            mineCounter++;
        }

        if (x < cells.length - 1 && y < cells[x].length - 1 && cells[x + 1][y + 1].isMine()) {
            mineCounter++;
        }

        if (y < cells[x].length - 1 && cells[x][y + 1].isMine()) {
            mineCounter++;
        }

        if (x > 0 && y < cells[x].length - 1 && cells[x - 1][y + 1].isMine()) {
            mineCounter++;
        }

        if (x > 0 && cells[x - 1][y].isMine()) {
            mineCounter++;
        }

        return mineCounter;

    }

}

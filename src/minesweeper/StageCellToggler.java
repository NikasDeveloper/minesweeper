package minesweeper;

import minesweeper.utilities.Toogler;
import javax.swing.*;
import java.util.ArrayList;

public class StageCellToggler implements Toogler {

    @Override
    public void toogleCell(StageCell cell, JToggleButton button) {
        cell.emitPress();
        button.setSelected(true);
        button.setEnabled(false);
        button.setText(cell.getText());
    }

    @Override
    public void toggleAllCells(StageCell[][] cells, JToggleButton[][] buttons) {
        for (StageCell[] cellRow : cells)
            for (StageCell cell : cellRow)
                if (!cell.isPressed()) this.toogleCell(cell, buttons[cell.getX()][cell.getY()]);
    }

    @Override
    public void toggleZeroCells(int x, int y, Stage stage, JToggleButton[][] buttons) {

        if (stage.getCells()[x][y].getMinesAround() != 0) return;

        ArrayList<StageCell> neighbours = stage.getCellNeighbours(x, y);

        for (StageCell neighbour : neighbours) {
            if (neighbour.isSelected()) continue;
            this.toogleCell(neighbour, buttons[neighbour.getX()][neighbour.getY()]);
            if (neighbour.getMinesAround() != 0) continue;
            this.toggleZeroCells(neighbour.getX(), neighbour.getY(), stage, buttons);
        }

    }

}
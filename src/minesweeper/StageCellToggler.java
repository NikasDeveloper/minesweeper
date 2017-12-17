package minesweeper;

import javax.swing.*;

public class StageCellToggler {

    public void toogleCell(StageCell cell, JToggleButton button) {
        cell.emitPress();
        button.setSelected(true);
        button.setEnabled(false);
        button.setText(cell.getText());
    }

    public void toggleAllCells(StageCell[][] cells, JToggleButton[][] buttons) {
        for (StageCell[] cellRow : cells)
            for (StageCell cell : cellRow)
                if (!cell.isPressed()) this.toogleCell(cell, buttons[cell.getX()][cell.getY()]);
    }

    public void toggleZeroCells(int x, int y, StageCell[][] cells, JToggleButton[][] buttons) {

        if (cells[x][y].getMinesAround() != 0) return;

        if (x > 0 && y > 0 && !cells[x - 1][y - 1].isSelected()) {
            this.toogleCell(cells[x - 1][y - 1], buttons[x - 1][y - 1]);
            if (cells[x - 1][y - 1].getMinesAround() == 0) this.toggleZeroCells(x - 1, y - 1, cells, buttons);
        }

        if (y > 0 && !cells[x][y - 1].isSelected()) {
            this.toogleCell(cells[x][y - 1], buttons[x][y - 1]);
            if (cells[x][y - 1].getMinesAround() == 0) this.toggleZeroCells(x, y - 1, cells, buttons);
        }

        if (x < cells.length - 1 && y > 0 && !cells[x + 1][y - 1].isSelected()) {
            this.toogleCell(cells[x + 1][y - 1], buttons[x + 1][y - 1]);
            if (cells[x + 1][y - 1].getMinesAround() == 0) this.toggleZeroCells(x + 1, y - 1, cells, buttons);
        }

        if (x < cells.length - 1 && !cells[x + 1][y].isSelected()) {
            this.toogleCell(cells[x + 1][y], buttons[x + 1][y]);
            if (cells[x + 1][y].getMinesAround() == 0) this.toggleZeroCells(x + 1, y, cells, buttons);
        }

        if (x < cells.length - 1 && y < cells[x].length - 1 && !cells[x + 1][y + 1].isSelected()) {
            this.toogleCell(cells[x + 1][y + 1], buttons[x + 1][y + 1]);
            if (cells[x + 1][y + 1].getMinesAround() == 0) this.toggleZeroCells(x + 1, y + 1, cells, buttons);
        }

        if (y < cells[x].length - 1 && !cells[x][y + 1].isSelected()) {
            this.toogleCell(cells[x][y + 1], buttons[x][y + 1]);
            if (cells[x][y + 1].getMinesAround() == 0) this.toggleZeroCells(x, y + 1, cells, buttons);
        }

        if (x > 0 && y < cells[x].length - 1 && !cells[x - 1][y + 1].isSelected()) {
            this.toogleCell(cells[x - 1][y + 1], buttons[x - 1][y + 1]);
            if (cells[x - 1][y + 1].getMinesAround() == 0) this.toggleZeroCells(x - 1, y + 1, cells, buttons);
        }

        if (x > 0 && !cells[x - 1][y].isSelected()) {
            this.toogleCell(cells[x - 1][y], buttons[x - 1][y]);
            if (cells[x - 1][y].getMinesAround() == 0) this.toggleZeroCells(x - 1, y, cells, buttons);
        }
        
    }

}
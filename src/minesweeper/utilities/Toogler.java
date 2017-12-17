package minesweeper.utilities;

import minesweeper.Stage;
import minesweeper.StageCell;
import javax.swing.*;

public interface Toogler {
    public void toogleCell(StageCell cell, JToggleButton button);
    public void toggleAllCells(StageCell[][] cells, JToggleButton[][] buttons);
    public void toggleZeroCells(int x, int y, Stage stage, JToggleButton[][] buttons);
}

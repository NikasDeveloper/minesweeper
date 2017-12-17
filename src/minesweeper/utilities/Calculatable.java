package minesweeper.utilities;

import minesweeper.Stage;

public interface Calculatable {
    public int calculateMinesAround(int x, int y, Stage stage);
    public void setMineCounter(Stage stage);
}

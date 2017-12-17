package minesweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * @author LebedenkoN
 */
public class Stage implements ActionListener {

    private final int STAGE_SIZE = 20;
    private final int TOTAL_MINES = 50;
    private StageCell[][] cells;

    public Stage() {
        this.cells = new StageCell[STAGE_SIZE][STAGE_SIZE];
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

    public void initCells() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new StageCell(new Coordinate(i, j));
                cells[i][j].addActionListener(this);
            }
        }
    }

    private void showStageCells() {
        for (StageCell[] cellRow : this.cells) {
            for (StageCell cell : cellRow) {
                if (cell.isPressed()) continue;
                String btnText = cell.isMine() ? "X" : cell.getMinesAround() + "";
                cell.setText(btnText);
                cell.emitPress();
            }
        }
    }

    private void toggleZeroCells(Coordinate coordinate) {

        int x = coordinate.getX();
        int y = coordinate.getY();

        if (cells[x][y].getMinesAround() != 0) return;


        // TODO REFACTOR
        if (x > 0 && y > 0 && !cells[x - 1][y - 1].isSelected()) {
            cells[x - 1][y - 1].setText(Integer.toString(cells[x - 1][y - 1].getMinesAround()));
            cells[x - 1][y - 1].emitPress();
            if (cells[x - 1][y - 1].getMinesAround() == 0) {
                this.toggleZeroCells(new Coordinate(x - 1, y - 1));
            }
        }

        if (y > 0 && !cells[x][y - 1].isSelected()) {
            cells[x][y - 1].setText(cells[x][y - 1].getMinesAround() + "");
            cells[x][y - 1].emitPress();
            if (cells[x][y - 1].getMinesAround() == 0) {
                this.toggleZeroCells(new Coordinate(x, y - 1));
            }
        }

        if (x < cells.length - 1 && y > 0 && !cells[x + 1][y - 1].isSelected()) {
            cells[x + 1][y - 1].setText(Integer.toString(cells[x + 1][y - 1].getMinesAround()));
            cells[x + 1][y - 1].emitPress();
            if (cells[x + 1][y - 1].getMinesAround() == 0) {
                this.toggleZeroCells(new Coordinate(x + 1, y - 1));
            }
        }

        if (x < cells.length - 1 && !cells[x + 1][y].isSelected()) {
            cells[x + 1][y].setText(cells[x + 1][y].getMinesAround() + "");
            cells[x + 1][y].emitPress();
            if (cells[x + 1][y].getMinesAround() == 0) {
                this.toggleZeroCells(new Coordinate(x + 1, y));
            }
        }

        if (x < cells.length - 1 && y < cells[x].length - 1 && !cells[x + 1][y + 1].isSelected()) {
            cells[x + 1][y + 1].setText(cells[x + 1][y + 1].getMinesAround() + "");
            cells[x + 1][y + 1].emitPress();
            if (cells[x + 1][y + 1].getMinesAround() == 0) {
                this.toggleZeroCells(new Coordinate(x + 1, y + 1));
            }
        }

        if (y < cells[x].length - 1 && !cells[x][y + 1].isSelected()) {
            cells[x][y + 1].setText(cells[x][y + 1].getMinesAround() + "");
            cells[x][y + 1].emitPress();
            if (cells[x][y + 1].getMinesAround() == 0) {
                this.toggleZeroCells(new Coordinate(x, y + 1));
            }
        }

        if (x > 0 && y < cells[x].length - 1 && !cells[x - 1][y + 1].isSelected()) {
            cells[x - 1][y + 1].setText(cells[x - 1][y + 1].getMinesAround() + "");
            cells[x - 1][y + 1].emitPress();
            if (cells[x - 1][y + 1].getMinesAround() == 0) {
                this.toggleZeroCells(new Coordinate(x - 1, y + 1));
            }
        }

        if (x > 0 && !cells[x - 1][y].isSelected()) {
            cells[x - 1][y].setText(cells[x - 1][y].getMinesAround() + "");
            cells[x - 1][y].emitPress();
            if (cells[x - 1][y].getMinesAround() == 0) {
                this.toggleZeroCells(new Coordinate(x - 1, y));
            }
        }

    }

    private int countToggledCells() {

        int toggledCells = 0;

        for (StageCell[] cellRow : cells) {
            for (StageCell cell : cellRow) {
                toggledCells += cell.isPressed() ? 1 : 0;
            }
        }

        return toggledCells;

    }

    private boolean isWin() {
        return this.countToggledCells() == (STAGE_SIZE * STAGE_SIZE - TOTAL_MINES);
    }

    private void showLooseNotification() {
        JOptionPane.showMessageDialog(null, "Game over!");
    }

    private void showWinNotification() {
        JOptionPane.showMessageDialog(null, "You won!");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        StageCell cell = (StageCell) e.getSource();

        if (cell.isPressed()) {
            cell.emitPress();
            return;
        }

        cell.emitPress();

        if (cell.isMine()) {
            cell.setText("X");
            this.showStageCells();
            this.showLooseNotification();
            return;
        }

        cell.setText(Integer.toString(cell.getMinesAround()));
        this.toggleZeroCells(cell.getCoordinate());

        if (this.isWin()) {
            this.showStageCells();
            this.showWinNotification();
        }

    }

}

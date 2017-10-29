package minesweeper;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author LebedenkoN
 */
public class Stage implements ActionListener {

    private final int STAGE_SIZE = 20;
    private final int TOTAL_MINES = 20;
    private Container grid;
    private StageCell[][] cells;

    public Stage() {
        this.grid = new Container();
        this.cells = new StageCell[STAGE_SIZE][STAGE_SIZE];
    }

    public Container getGrid() {
        return grid;
    }

    public void initGridLayout() {
        this.grid.setLayout(new GridLayout(STAGE_SIZE, STAGE_SIZE));
    }

    public void appendGridCells() {
        for (StageCell[] cellRow : this.cells) {
            for (StageCell cell : cellRow) {
                this.grid.add(cell);
            }
        }
    }

    public void initCells() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new StageCell(new Coordinate(i, j));
                cells[i][j].addActionListener(this);
            }
        }
    }

    public void plantMines() {

        CoordinateGenerator coordinateGenerator = new CoordinateGenerator();
        ArrayList<Coordinate> coordinates;

        coordinates = coordinateGenerator.generateCoordinates(
                STAGE_SIZE - 1,
                TOTAL_MINES
        );

        for (Coordinate coordinate : coordinates) {
            this.cells[coordinate.getX()][coordinate.getY()].setMine(true);
        }

    }

    public void calculateMinesAround() {

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j].setMinesAround(MineCalculator.calculateMinesArount(
                        new Coordinate(i, j),
                        cells)
                );
            }
        }

    }

    public void showStageCells() {
        for (StageCell[] cellRow : this.cells) {
            for (StageCell cell : cellRow) {
                if (cell.isPressed()) {
                    continue;
                }
                String btnText = cell.isMine() ? "X" : cell.getMinesAround() + "";
                cell.setText(btnText);
                cell.setPressed(true);
                cell.toggleSelected();
            }
        }
    }

    public void toggleZeroCells(Coordinate coordinate) {

        int x = coordinate.getX();
        int y = coordinate.getY();

        if (cells[x][y].getMinesAround() != 0) {
            return;
        }

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

    @Override
    public void actionPerformed(ActionEvent e
    ) {

        StageCell cell = (StageCell) e.getSource();

        if (cell.isPressed()) {
            cell.toggleSelected();
            return;
        }

        cell.emitPress();

        if (cell.isMine()) {
            cell.setText("X");
            JOptionPane.showMessageDialog(null, "Game over!");
            this.showStageCells();
        } else {
            cell.setText(cell.getMinesAround() + "");
            this.toggleZeroCells(cell.getCoordinate());
        }

    }

}

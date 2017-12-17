package minesweeper;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author Nikolajus Lebedenko PRif-15/1
 */
public class Minesweeper {

    public static void main(String[] args) {

        GameFrame gameFrame = new GameFrame("Minesweeper");
        Container grid = new Container();
        Stage stage = new Stage();

        grid.setLayout(new GridLayout(stage.getStageSize(), stage.getStageSize()));
        stage.initCells();

        MinePlanter minePlanter = new MinePlanter(stage.getStageSize(), stage.getTotalMines());
        minePlanter.plantMines(stage.getCells());

        // Add cells to grid
        for (StageCell[] cellRow : stage.getCells()) for (StageCell cell : cellRow) grid.add(cell);

        MineCalculator mineCalculator = new MineCalculator();
        mineCalculator.setMineCounter(stage.getCells());

        gameFrame.add(grid, BorderLayout.CENTER);
        gameFrame.setVisible(true);

    }

}

// TODO REMOVE DEPENDECIE FROM SWING
// GENEREATE CORDINATOR REMOVE DEPENDENCY
// SPECIAL CELL IF WHICH OPENS ALL
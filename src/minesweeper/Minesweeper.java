package minesweeper;

import javax.swing.*;
import java.awt.*;

/**
 * @author Nikolajus Lebedenko PRif-15/1
 */
public class Minesweeper {

    public static void main(String[] args) {

        GameFrame gameFrame = new GameFrame("Minesweeper");
        Container grid = new Container();
        Stage stage = new Stage();
        JToggleButton[][] toggleButtons = new JToggleButton[stage.getStageSize()][stage.getStageSize()];
        MinePlanter minePlanter = new MinePlanter(stage.getStageSize(), stage.getTotalMines());
        MineCalculator mineCalculator = new MineCalculator();

        grid.setLayout(new GridLayout(stage.getStageSize(), stage.getStageSize()));
        minePlanter.plantMines(stage.getCells());
        mineCalculator.setMineCounter(stage);

        for (StageCell[] cellRow : stage.getCells()) {
            for (StageCell cell : cellRow) {
                toggleButtons[cell.getX()][cell.getY()] = new JToggleButton();
                toggleButtons[cell.getX()][cell.getY()].addActionListener(
                        new StageCellActionListener(cell, stage, toggleButtons)
                );
                grid.add(toggleButtons[cell.getX()][cell.getY()]);
            }
        }

        gameFrame.add(grid, BorderLayout.CENTER);
        gameFrame.setVisible(true);

    }

}
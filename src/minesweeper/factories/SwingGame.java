package minesweeper.factories;

import minesweeper.GameFrame;
import minesweeper.StageCell;
import minesweeper.StageCellActionListener;
import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

public class SwingGame extends Game {

    private Container grid;
    private JToggleButton[][] toggleButtons;

    SwingGame() {
        super();
        this.toggleButtons = new JToggleButton[stage.getStageSize()][stage.getStageSize()];
        this.loadGrid();
        this.linkCellsWithButtons();
        this.loadGameFrame();
    }

    private void loadGrid(){
        this.grid = new Container();
        this.grid.setLayout(new GridLayout(stage.getStageSize(), stage.getStageSize()));
    }

    private void linkCellsWithButtons() {
        for (StageCell[] cellRow : stage.getCells()) {
            for (StageCell cell : cellRow) {
                this.toggleButtons[cell.getX()][cell.getY()] = new JToggleButton();
                this.toggleButtons[cell.getX()][cell.getY()].addActionListener(
                        new StageCellActionListener(cell, stage, toggleButtons)
                );
                this.grid.add(this.toggleButtons[cell.getX()][cell.getY()]);
            }
        }
    }

    private void loadGameFrame() {
        GameFrame gameFrame = new GameFrame("Minesweeper");
        gameFrame.add(this.grid, BorderLayout.CENTER);
        gameFrame.setVisible(true);
    }

    @Override
    public void run() {
        try {
            SwingUtilities.invokeAndWait(SwingGame::new);
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}

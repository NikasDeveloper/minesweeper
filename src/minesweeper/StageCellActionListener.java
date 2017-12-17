package minesweeper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StageCellActionListener implements ActionListener {

    private StageCell cell;
    private Stage stage;
    private JToggleButton[][] toggleButtons;

    public StageCellActionListener(StageCell cell, Stage stage, JToggleButton[][] toggleButtons) {
        super();
        this.cell = cell;
        this.stage = stage;
        this.toggleButtons = toggleButtons;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JToggleButton toggleButton = (JToggleButton) e.getSource();
        GameRules gameRules = new GameRules();
        StageCellToggler toggler = new StageCellToggler();

        toggler.toogleCell(cell, toggleButton);

        if (gameRules.isLoose(cell)) {
            toggler.toggleAllCells(stage.getCells(), toggleButtons);
            Notifier.loose();
            return;
        }

        toggler.toggleZeroCells(cell.getX(), cell.getY(), stage.getCells(), toggleButtons);

        if (gameRules.isWin(stage)) Notifier.win();

    }

}

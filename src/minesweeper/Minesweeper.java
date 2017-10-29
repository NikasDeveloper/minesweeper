package minesweeper;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * @author Nikolajus Lebedenko PRif-15/1
 */
public class Minesweeper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame("Minesweeper");
        Stage stage = new Stage();

        stage.initGridLayout();
        stage.initCells();
        stage.appendGridCells();
        stage.plantMines();
        stage.calculateMinesAround();

        gameFrame.add(stage.getGrid(), BorderLayout.CENTER);
        gameFrame.show();
    }

}

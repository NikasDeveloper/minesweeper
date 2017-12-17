package minesweeper;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * @author LebedenkoN
 */
public class Stage{

    private final int STAGE_SIZE = 20;
    private final int TOTAL_MINES = 50;
    private StageCell[][] cells;

    public Stage() {
        this.cells = new StageCell[STAGE_SIZE][STAGE_SIZE];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new StageCell(new Coordinate(i, j));
            }
        }
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

}

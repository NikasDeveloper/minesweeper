package minesweeper;

import org.junit.Test;

import static org.junit.Assert.*;

public class StageTest {

    @Test
    public void getCellNeighbours() throws Exception {
        Stage stage = new Stage();
        assertTrue(3 == stage.getCellNeighbours(0, 0).size() - 1);
    }

    @Test
    public void getMinedFieldCount() throws Exception {
        Stage stage = new Stage();
        MinePlanter minePlanter = new MinePlanter(stage.getStageSize(), stage.getTotalMines());
        MineCalculator mineCalculator = new MineCalculator();
        minePlanter.plantMines(stage.getCells());
        mineCalculator.setMineCounter(stage);

        int mineCounter = 0;
        for (StageCell[] cellsRow: stage.getCells())
            for (StageCell cell : cellsRow)
                if(cell.isMine()) mineCounter++;

        assertTrue(stage.getTotalMines() == mineCounter);
    }

    @Test
    public void getStageSize() throws Exception {
        Stage stage = new Stage();

        int cellCounter = 0;

        for (StageCell[] cellsRow: stage.getCells())
            for (StageCell cell : cellsRow)
                cellCounter++;

        assertTrue(stage.getStageSize() * stage.getStageSize() == cellCounter);
    }

}
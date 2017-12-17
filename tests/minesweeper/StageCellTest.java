package minesweeper;

import org.junit.Test;

import static org.junit.Assert.*;

public class StageCellTest {

    @Test
    public void getText() throws Exception {
        StageCell cell = new StageCell(new Coordinate());
        assertTrue(cell.getText().equals("0"));
        cell.setMine(true);
        assertTrue(cell.getText().equals("X"));
    }

    @Test
    public void emitPress() throws Exception {
        StageCell cell = new StageCell(new Coordinate());
        cell.emitPress();
        assertTrue(cell.isPressed() && cell.isSelected());
    }

}
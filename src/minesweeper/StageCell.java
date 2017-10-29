package minesweeper;

import javax.swing.JToggleButton;

/**
 * @author LebedenkoN
 */
public class StageCell extends JToggleButton {

    private boolean pressed;
    private boolean mine;
    private int minesAround;
    private Coordinate coordinate;

    StageCell(Coordinate coordinate) {
        super();
        this.pressed = false;
        this.mine = false;
        this.minesAround = 0;
        this.coordinate = new Coordinate();
        this.coordinate = coordinate;
    }

    public boolean isPressed() {
        return this.pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    public boolean isMine() {
        return this.mine;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public void toggleSelected() {
        this.setSelected(true);
    }

    public int getMinesAround() {
        return this.minesAround;
    }

    public void setMinesAround(int minesAround) {
        this.minesAround = minesAround;
    }

    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    public void emitPress() {
        this.setPressed(true);
        this.toggleSelected();
    }

}

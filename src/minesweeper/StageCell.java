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

    StageCell() {
        super();
        this.pressed = false;
        this.mine = false;
        this.minesAround = 0;
        this.coordinate = new Coordinate();
    }

    StageCell(Coordinate coordinate) {
        super();
        this.pressed = false;
        this.mine = false;
        this.minesAround = 0;
        this.coordinate = new Coordinate();
        this.coordinate = coordinate;
    }

    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    public boolean isMine() {
        return mine;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public void toggleSelected() {
        this.setSelected(true);
    }

    public int getMinesAround() {
        return minesAround;
    }

    public void setMinesAround(int minesAround) {
        this.minesAround = minesAround;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void emitPress() {
        this.setPressed(true);
        this.toggleSelected();
    }

}

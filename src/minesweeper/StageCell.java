package minesweeper;

/**
 * @author LebedenkoN
 */
public class StageCell {

    private boolean pressed;
    private boolean mine;
    private boolean selected;
    private int minesAround;
    private Coordinate coordinate;

    StageCell(Coordinate coordinate) {
        super();
        this.pressed = false;
        this.mine = false;
        this.selected = false;
        this.minesAround = 0;
        this.coordinate = new Coordinate();
        this.coordinate = coordinate;
    }

    public boolean isPressed() {
        return this.pressed;
    }

    public boolean isMine() {
        return this.mine;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public boolean isSelected() {
        return selected;
    }

    public int getMinesAround() {
        return this.minesAround;
    }

    public void setMinesAround(int minesAround) {
        this.minesAround = minesAround;
    }

    public int getX() {
        return this.coordinate.getX();
    }

    public int getY() {
        return this.coordinate.getY();
    }

    public String getText() {
        return this.mine ? "X" : this.minesAround + "";
    }

    public void emitPress() {
        this.pressed = true;
        this.selected = true;
    }

}

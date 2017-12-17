package minesweeper;

/**
 * @author LebedenkoN
 */
public class Coordinate {

    private int x;
    private int y;

    public Coordinate() {
        this.x = 0;
        this.y = 0;
    }

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        final Coordinate other = (Coordinate) obj;
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public String toString() {
        return "\nCoordinate{" + "x=" + x + ", y=" + y + "}";
    }

}

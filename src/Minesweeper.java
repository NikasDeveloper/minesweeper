import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Minesweeper {

    public static final int FIELD_SIZE = 8;

    public static final int TOTAL_MINES = 10;

    public static final int TOTAL_FLAGS = 5;

    public static Map<Integer, int[]> field = new HashMap<>();

    public static final Map<Integer, Map<Integer, Integer>> MINES = fillMines();

    public static void populateField(Map<Integer, int[]> field) {
        for (int i = 0; i < FIELD_SIZE; i++) field.put(i, new int[FIELD_SIZE]);
    }

    public static Map<Integer, Map<Integer, Integer>> fillMines() {

        Map<Integer, Map<Integer, Integer>> mines = new HashMap<>();

        for (int i = 0; i < TOTAL_MINES; i++) mines.put(i, createMine(mines));

        return mines;
    }

    public static Map<Integer, Integer> createMine(Map<Integer, Map<Integer, Integer>> mines) {

        Map<Integer, Integer> mine = new HashMap<>();

        int cordX = getRandomCord();
        int cordY = getRandomCord();

        while (true) {

            if (!mineExists(mines, cordX, cordY)) break;

            cordX = getRandomCord();
            cordY = getRandomCord();

        }

        mine.put(cordX, cordY);

        return mine;

    }

    public static int getRandomCord() {
        return ThreadLocalRandom.current().nextInt(0, FIELD_SIZE + 1);
    }

    public static boolean mineExists(Map<Integer, Map<Integer, Integer>> mines, int x, int y) {

        final boolean[] mineFound = {false};

        mines.forEach((k, v) -> {

            if(v.keySet().toArray()[0].equals(x) && v.values().toArray()[0].equals(y)) mineFound[0] = true;
            

        });

        return mineFound[0];

    }

    public static void printField(Map<Integer, int[]> field) {

        field.forEach((k, v) -> {

            System.out.println("Row: " + (k + 1));

            for (int cell : v) {
                System.out.print(cell + " ");
            }

            System.out.println();

        });

    }

    public static void main(String[] args) {

        populateField(field);

        System.out.println(MINES);

        //printField(field);

    }
}

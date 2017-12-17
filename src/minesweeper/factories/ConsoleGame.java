package minesweeper.factories;

public class ConsoleGame extends Game {

    @Override
    public void run() {
        try {
            throw new Exception("Not implemented.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

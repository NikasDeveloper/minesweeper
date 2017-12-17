package minesweeper.factories;

public class GameFactory {
    public Game createGame(String param){
        if(param.equals("console")){
            return new ConsoleGame();
        }
        else {
            return new SwingGame();
        }
    }
}

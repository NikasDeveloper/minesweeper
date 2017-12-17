package minesweeper;

import minesweeper.factories.Game;
import minesweeper.factories.GameFactory;


/**
 * @author Nikolajus Lebedenko PRif-15/1
 */
public class Minesweeper {

    public static void main(String[] args) {

        GameFactory gameFactory = new GameFactory();
        Game game = gameFactory.createGame("swing");
        game.run();

    }

}
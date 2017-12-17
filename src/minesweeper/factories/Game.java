package minesweeper.factories;

import minesweeper.MineCalculator;
import minesweeper.MinePlanter;
import minesweeper.Stage;

public abstract class Game {

    protected Stage stage;

    public Game() {
        this.stage = new Stage();
        this.boot();
    }

    protected void boot() {
        MinePlanter minePlanter = new MinePlanter(stage.getStageSize(), stage.getTotalMines());
        MineCalculator mineCalculator = new MineCalculator();
        minePlanter.plantMines(stage.getCells());
        mineCalculator.setMineCounter(stage);
    }

    public abstract void run();

}

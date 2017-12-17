package minesweeper;

public class GameRules {

    public boolean isLoose(StageCell cell) {
        return cell.isMine();
    }

    public boolean isWin(Stage stage) {

        int toggledCells = 0;

        for (StageCell[] cellRow : stage.getCells())
            for (StageCell cell : cellRow) toggledCells += cell.isPressed() ? 1 : 0;

        return toggledCells == (stage.getStageSize() * stage.getStageSize() - stage.getTotalMines());

    }

}

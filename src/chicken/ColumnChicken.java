package chicken;

import game.GameBoard;
import shot.BlackShot;
import shot.BlueShot;
import shot.RedShot;
import shot.YellowShot;

public class ColumnChicken extends Chicken{

	public ColumnChicken(GameBoard gameBoard, int column, int row, int width, int height) {
		super(gameBoard, column, row, width, height, "column");
	}

	@Override
	public void visit(YellowShot yellowShot) {
	}

	@Override
	public void visit(RedShot redShot) {
	}

	@Override
	public void visit(BlackShot blackShot) {
		gameBoard.DestroyColumn(column);
	}

	@Override
	public void visit(BlueShot blueShot) {
	}

}

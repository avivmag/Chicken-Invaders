package chicken;

import game.GameBoard;
import shot.BlackShot;
import shot.BlueShot;
import shot.RedShot;
import shot.YellowShot;

public class RowChicken extends Chicken{

	public RowChicken(GameBoard gameBoard, int column, int row, int width, int height) {
		super(gameBoard, column, row, width, height, "row");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visit(YellowShot yellowShot) {
	}

	@Override
	public void visit(RedShot redShot) {
	}

	@Override
	public void visit(BlackShot blackShot) {
		gameBoard.DestroyRow(row);
	}

	@Override
	public void visit(BlueShot blueShot) {
	}

}

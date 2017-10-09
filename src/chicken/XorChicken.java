package chicken;

import game.GameBoard;
import shot.BlackShot;
import shot.BlueShot;
import shot.RedShot;
import shot.YellowShot;

public class XorChicken extends Chicken{

	public XorChicken(GameBoard gameBoard, int column, int row, int width, int height) {
		super(gameBoard, column, row, width, height, "xor");
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
		gameBoard.DestroyCircle(column, row);
		gameBoard.DestroyColumn(column);
		gameBoard.DestroyRow(row);
	}

	@Override
	public void visit(BlueShot blueShot) {
	}

}

package chicken;

import game.GameBoard;
import shot.BlackShot;
import shot.BlueShot;
import shot.RedShot;
import shot.YellowShot;

public class FluChicken extends Chicken{
	
	public FluChicken(GameBoard gameBoard, int column, int row, int width, int height) {
		super(gameBoard, column, row, width, height, "flu");
		
	}

	@Override
	public void visit(YellowShot yellowShot) {
	}

	@Override
	public void visit(RedShot redShot) {
	}

	@Override
	public void visit(BlackShot blackShot) {
		for (int i = 0; i < 4; i++) {
			gameBoard.DestroyRow(i);
		}
	}

	@Override
	public void visit(BlueShot blueShot) {
	}

}

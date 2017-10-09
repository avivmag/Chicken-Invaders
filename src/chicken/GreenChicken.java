package chicken;

import game.GameBoard;
import shot.BlackShot;
import shot.BlueShot;
import shot.RedShot;
import shot.YellowShot;

public class GreenChicken extends Chicken{

	public GreenChicken(GameBoard gameBoard, int column, int row, int width, int height) {
		super(gameBoard, column, row, width, height, "green");
		gameBoard.getGreenChickensList().add(this);
	}

	@Override
	public void visit(YellowShot yellowShot) {
		die();
	}

	@Override
	public void visit(RedShot redShot) {
	}

	@Override
	public void visit(BlackShot blackShot) {
	}

	@Override
	public void visit(BlueShot blueShot) {
		die();
	}

	@Override
	protected void removeThisFromLists()
	{
		super.removeThisFromLists();
		gameBoard.getGreenChickensList().remove(this);
	}
}

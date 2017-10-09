package chicken;

import game.GameBoard;
import shot.BlackShot;
import shot.BlueShot;
import shot.RedShot;
import shot.YellowShot;

public class PurpleChicken extends Chicken{

	public PurpleChicken(GameBoard gameBoard, int column, int row, int width, int height) {
		super(gameBoard, column, row, width, height, "purple");
		gameBoard.getPurpleChickensList().add(this);
	}

	@Override
	public void visit(YellowShot yellowShot) {
	}

	@Override
	public void visit(RedShot redShot) {
		die();
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
		gameBoard.getPurpleChickensList().remove(this);
	}
}

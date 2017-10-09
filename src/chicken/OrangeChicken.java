package chicken;

import game.GameBoard;
import shot.BlackShot;
import shot.BlueShot;
import shot.RedShot;
import shot.YellowShot;

public class OrangeChicken extends Chicken{

	public OrangeChicken(GameBoard gameBoard, int column, int row, int width, int height) {
		super(gameBoard, column, row, width, height, "orange");
		gameBoard.getOrangeChickensList().add(this);
	}

	@Override
	public void visit(YellowShot yellowShot) {
		die();
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
	}

	@Override
	protected void removeThisFromLists()
	{
		super.removeThisFromLists();
		gameBoard.getOrangeChickensList().remove(this);
	}
}

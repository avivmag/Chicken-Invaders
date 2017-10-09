package chicken;

import java.util.Random;

import game.GameBoard;
import shot.BlackShot;
import shot.BlueShot;
import shot.RedShot;
import shot.YellowShot;

public class YellowChicken extends Chicken{
	private Random rand = new Random();
	public YellowChicken(GameBoard gameBoard, int column, int row, int width, int height) {
		super(gameBoard, column, row, width, height, "yellow");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visit(YellowShot yellowShot) {
		die();
	}

	@Override
	public void visit(RedShot redShot) {
		for (int i = 0; i < 2; i++)
			if(gameBoard.getOrangeChickensList().size() != 0)
				gameBoard.getOrangeChickensList().get(rand.nextInt(gameBoard.getOrangeChickensList().size())).die();
	}

	@Override
	public void visit(BlackShot blackShot) {
	}

	@Override
	public void visit(BlueShot blueShot) {
		for (int i = 0; i < 2; i++)
			if(gameBoard.getGreenChickensList().size() != 0)
				gameBoard.getGreenChickensList().get(rand.nextInt(gameBoard.getGreenChickensList().size())).die();
	}

}

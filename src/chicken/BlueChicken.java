package chicken;

import java.util.Random;

import game.GameBoard;
import shot.BlackShot;
import shot.BlueShot;
import shot.RedShot;
import shot.YellowShot;

public class BlueChicken extends Chicken{
	private Random rand = new Random();
	public BlueChicken(GameBoard gameBoard, int column, int row, int width, int height) {
		super(gameBoard, column, row, width, height, "blue");
	}

	@Override
	public void visit(YellowShot yellowShot) {
		for (int i = 0; i < 2; i++)
			if(gameBoard.getGreenChickensList().size() != 0)
				gameBoard.getGreenChickensList().get(rand.nextInt(gameBoard.getGreenChickensList().size())).die();
	}

	@Override
	public void visit(RedShot redShot) {
		for (int i = 0; i < 2; i++)
			if(gameBoard.getPurpleChickensList().size() != 0)
				gameBoard.getPurpleChickensList().get(rand.nextInt(gameBoard.getPurpleChickensList().size())).die();
		
	}

	@Override
	public void visit(BlackShot blackShot) {
	}

	@Override
	public void visit(BlueShot blueShot) {
		die();
	}
	
}

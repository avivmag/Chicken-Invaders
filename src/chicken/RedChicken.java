package chicken;

import java.util.Random;

import game.GameBoard;
import shot.BlackShot;
import shot.BlueShot;
import shot.RedShot;
import shot.YellowShot;

public class RedChicken extends Chicken{
	private Random rand = new Random();
	public RedChicken(GameBoard gameBoard, int column, int row, int width, int height) {
		super(gameBoard, column, row, width, height, "red");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visit(YellowShot yellowShot) {
		for (int i = 0; i < 2; i++)
			if(gameBoard.getOrangeChickensList().size() != 0)
				gameBoard.getOrangeChickensList().get(rand.nextInt(gameBoard.getOrangeChickensList().size())).die();
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
		for (int i = 0; i < 2; i++)
			if(gameBoard.getPurpleChickensList().size() != 0)
				gameBoard.getPurpleChickensList().get(rand.nextInt(gameBoard.getPurpleChickensList().size())).die();
	}
}

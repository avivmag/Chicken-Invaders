package chicken;

import game.GameBoard;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import shot.BlackShot;
import shot.BlueShot;
import shot.RedShot;
import shot.YellowShot;

public abstract class Chicken extends JLabel implements Visitor{
	private int width;
	private int height;
	protected int column;
	protected int row;
	protected GameBoard gameBoard;
	private Timer timeToDie;
	
	public Chicken(GameBoard gameBoard, int column, int row, int width, int height, String imagePath)
	{
		setOpaque(false);
		this.setWidth(width);
		this.setHeight(height);
		this.gameBoard = gameBoard;
		this.row = row;
		this.column = column;
		
		setOpaque(false);
		setIcon(new ImageIcon(getImage(imagePath)));
		gameBoard.getChickens()[column][row] = this;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	protected Image getImage(String imagePath)
	{
		BufferedImage scaled;
		Graphics g;
		BufferedImage bg = new BufferedImage((int) width, (int) height, BufferedImage.TYPE_INT_ARGB);

		imagePath = "Resources/chicken_" + imagePath + ".PNG";
		
		BufferedImage fg = null;
		try { fg = ImageIO.read(getClass().getResource(imagePath)); }
		catch (IOException e) { }

		scaled = new BufferedImage((int) (width), (int) (height), BufferedImage.TYPE_INT_ARGB);
		g = scaled.getGraphics();
		g.drawImage(fg,0, 0, scaled.getWidth(), scaled.getHeight(), null);
		bg.getGraphics().drawImage(scaled, bg.getWidth()/2 - scaled.getWidth()/2, bg.getHeight()/2 - scaled.getHeight()/2, null );
		
		return bg;
	}
	
	public void die()
	{
		gameBoard.getChickens()[column][row] = null;
		setIcon(new ImageIcon(getImage("explosion")));
		
		try { AudioInputStream audioIn = AudioSystem.getAudioInputStream(getClass().getResource("Resources/explosion.wav"));
		Clip clip = AudioSystem.getClip();
		clip.open(audioIn);
		clip.start();
		} catch(Exception e){System.out.println(e);}
		
		timeToDie = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gameBoard.removeChicken(Chicken.this);
				timeToDie.stop();
				removeThisFromLists();
			}
		});
		removeThisFromLists();
		
		timeToDie.setInitialDelay(200);
		timeToDie.start();
	}
	protected void removeThisFromLists()
	{
		gameBoard.getChickensList().remove(this);
	}

	public abstract void visit(YellowShot yellowShot);
	
	public abstract void visit(RedShot redShot);

	public abstract void visit(BlackShot blackShot);
	
	public abstract void visit(BlueShot blueShot);
}

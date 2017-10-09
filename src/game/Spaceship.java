package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Spaceship extends JLabel{

	public Spaceship()
	{
		setOpaque(false);
		try { setIcon(new ImageIcon(ImageIO.read(getClass().getResource("Resources/spaceship.PNG"))));}
		catch (Exception e) {System.out.println(e.toString());}
	}
}
package shot;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import chicken.Visitor;

public abstract class Shot extends JLabel{
	public Shot(String imagePath)
	{
		setOpaque(false);
		try { setIcon(new ImageIcon(ImageIO.read(getClass().getResource("Resources/shot_" + imagePath + ".PNG"))));}
		catch (Exception e) {System.out.println(e.toString());}
	}
	
	public abstract void shooting(Visitor v);
}

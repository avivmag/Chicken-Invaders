package menu;

import game.GameBoard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.SpinnerNumberModel;

public class MainMenu extends JFrame implements MouseListener {
	private JLabel[] menus = new JLabel[3];
	private JSpinner levels;

	public MainMenu() {
		int height = 800;
		int width = 800;
		
		//Panels
		JLayeredPane mainPanel = new JLayeredPane();
		JPanel backgroundPanel = new JPanel(new GridLayout());
		JPanel menusPanel = new JPanel();
		JPanel levelPanel = new JPanel(new GridLayout());
		menusPanel.setLayout(new BoxLayout(menusPanel, 1));
		

		try {
			JLabel background = new  JLabel(new ImageIcon(ImageIO.read(getClass().getResource("main_background.jpg"))));
			backgroundPanel.add(background);
		}
		catch (Exception e){System.out.println(e.toString());}

		//Panel bounds
		backgroundPanel.setBounds(0, 0, width, height);
		levelPanel.setBounds(0, 0, 10, 10);
		mainPanel.setBounds(0,0,100,100);

		//Menus names and level spinner
		menus[0] = new JLabel("New Game");
		menus[1] = new JLabel("High Score");
		menus[2] = new JLabel("Exit");
		levels = new JSpinner(new SpinnerNumberModel(1, 1, 6, 1));
		
		//Set font and color
		for (int i = 0; i < menus.length; i++) 
		{
			menus[i].setFont(new Font("Times New Roman",0,40));
			menus[i].setForeground(Color.RED);
		}

		//Add mouse listeners
		for (int i=0; i<menus.length; i++)
			menus[i].addMouseListener(this);

		//Spinner size
		levels.setPreferredSize(new Dimension(0, 0));
		levels.setFont(new Font("Times New Roman", 0, 20));
		((DefaultEditor) levels.getEditor()).getTextField().setEditable(false);
		levelPanel.add(levels);

		//Add to main panel
		menusPanel.add(menus[0]);
		menusPanel.add(menus[1]);
		menusPanel.add(levelPanel);
		menusPanel.add(menus[2]);

		menusPanel.setBounds(height / 3, width / 3, 200, 300);
		menusPanel.setOpaque(false);

		//Add layers
		mainPanel.add(backgroundPanel, new Integer(0));
		mainPanel.add(menusPanel, new Integer(1));

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Chicken");
		pack();
		add(mainPanel);
		setSize(width, height);
		setLocation(300, 100);
		setResizable(false);
		setVisible(true);
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource().equals(menus[0]))
		{
			dispose();
			new GameBoard(Integer.parseInt(levels.getValue().toString()));
		}
		
		if (arg0.getSource().equals(menus[1]))
		{
			dispose();
			new HighScores();
		}
		
		if (arg0.getSource().equals(menus[2]))
		{
			dispose();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		for (int i=0; i<menus.length; i++)
			if (arg0.getSource() == menus[i])
				menus[i].setForeground(Color.YELLOW);

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		for (int i=0; i<menus.length; i++)
			if (arg0.getSource() == menus[i])
				menus[i].setForeground(Color.RED);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}

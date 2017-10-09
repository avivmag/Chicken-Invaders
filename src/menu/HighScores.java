package menu;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class HighScores extends JFrame implements MouseListener {
	private JLabel back;
	
	public HighScores() {
		int height = 599;
		int width = 787;
		
		//Panels
		JLayeredPane mainPanel = new JLayeredPane();
		JPanel backgroundPanel = new JPanel(new GridBagLayout());
		JPanel scoresPanel = new JPanel(new GridLayout(5, 3, -50, -55));
		JPanel backPanel = new JPanel();
		
		JLabel[] players = new JLabel[15];
		
		try { 
			JLabel background = new  JLabel(new ImageIcon(ImageIO.read(getClass().getResource("highScore_background.PNG"))));
			backgroundPanel.add(background);
		}
		catch (Exception e){System.out.println(e.toString());}
		
		//Bounds
		backgroundPanel.setBounds(0, 0, width, height);
		scoresPanel.setBounds(120, 190, 500, 400);
		backPanel.setBounds(0, 0, 100, 100);
		int i = 0;
		//Read from file
		try 
		{
			File file = new File("HighScores.txt");
			BufferedReader output = new BufferedReader(new FileReader(file));
			String tmp = "";
			String[] playersStrings = new String[3];
			while (tmp != null)
			{
				tmp = output.readLine();
				if (tmp != null && !tmp.equals(""))
				{
					playersStrings = tmp.split(":-:-:");
					players[i]= new JLabel(playersStrings[0]);
					players[i+1] = new JLabel(playersStrings[1]);
					players[i+2] = new JLabel(playersStrings[2]);
					i += 3;
				}
			}
			
			output.close();
		}
		catch(Exception e) {}
		
		//If there is less than 5 players in the file set the labels to empty string
		for (int j = i; j < players.length; j++)
			if (players[j] == null)
				players[j] = new JLabel("");
		
		for ( i = 0; i < players.length; i++)
		{
			players[i].setForeground(Color.WHITE);
			players[i].setFont(new Font("Times New Roman", Font.BOLD, 20));
			scoresPanel.add(players[i]);
		}
		
		back = new JLabel("Back");
		back.setFont(new Font("Times New Roman", 0, 35));
		back.setForeground(Color.RED);
		back.addMouseListener(this);
		
		scoresPanel.setOpaque(false);
		backPanel.setOpaque(false);
		
		//Add to panels
		mainPanel.add(backgroundPanel, new Integer(0));
		mainPanel.add(scoresPanel, new Integer(1));
		mainPanel.add(backPanel, new Integer(1));
		backPanel.add(back);
		add(mainPanel);
		
		
		//Frame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(width, height);
		setLocation(300, 100);
		setResizable(false);
		setVisible(true);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == back)
		{
			dispose();
			new MainMenu();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource().equals(back))
		{
			back.setForeground(Color.WHITE);
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource().equals(back))
		{
			back.setForeground(Color.RED);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

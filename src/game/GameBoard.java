package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import menu.DiskHandler;
import menu.MainMenu;
import shot.BlackShot;
import shot.BlueShot;
import shot.RedShot;
import shot.Shot;
import shot.YellowShot;
import chicken.BlueChicken;
import chicken.Chicken;
import chicken.CircleChicken;
import chicken.ColumnChicken;
import chicken.FluChicken;
import chicken.GreenChicken;
import chicken.OrangeChicken;
import chicken.PlusChicken;
import chicken.PurpleChicken;
import chicken.RedChicken;
import chicken.RowChicken;
import chicken.XChicken;
import chicken.XorChicken;
import chicken.YellowChicken;

public class GameBoard extends JFrame implements KeyListener{
	private Chicken[][] chickens = new Chicken[8][4];
	private Spaceship spaceship;
	private Timer timerShot;
	private Shot shot = new BlackShot();
	private Shot nextShot = null;
	private boolean shotIsDead = true;
	private List<Chicken> chickensList = new ArrayList<>();
	private int stage;
	private List<OrangeChicken> orangeChickensList = new ArrayList<>();
	private List<GreenChicken> greenChickensList = new ArrayList<>();
	private List<PurpleChicken> purpleChickensList = new ArrayList<>();
	private JLabel shotsCountLabel;
	private int shotsCount = 0;
	private JLabel timeCountLabel;
	private JLayeredPane gameLayer;
	private long timeCount;
	private int grade;
	private Timer countTimeTimer;
	private JLabel whichStage;

	public GameBoard(int stage)
	{
		this(stage, 0);
	}

	public GameBoard(int stage, int grade)
	{
		this.stage = stage;
		this.grade = grade;
		setResizable(false);
		FlowLayout topPanelLayout = new FlowLayout(FlowLayout.CENTER, 150, 0);
		shotsCountLabel = new JLabel("Number of shots: 0");
		shotsCountLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		shotsCountLabel.setForeground(Color.WHITE);
		timeCountLabel = new JLabel("TIME: 0");
		timeCountLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		timeCountLabel.setForeground(Color.WHITE);
		whichStage = new JLabel("Stage: " + stage);
		whichStage.setForeground(Color.WHITE);
		whichStage.setFont(new Font("Times New Roman", Font.BOLD, 30));
		JPanel topPanel = new JPanel(topPanelLayout);
		topPanel.add(timeCountLabel);
		topPanel.add(whichStage);
		topPanel.add(shotsCountLabel);
		topPanel.setBackground(Color.BLACK);


		gameLayer = new JLayeredPane();


		setSize(1300, 900);
		JPanel backgroundPanel = new JPanel(new GridBagLayout());

		try { 
			JLabel background = new  JLabel(new ImageIcon(ImageIO.read(getClass().getResource("Resources/sky_background.jpg"))));
			backgroundPanel.add(background);
		}
		catch (Exception e){System.out.println(e.toString());}
		backgroundPanel.setBounds(0, 0, getWidth(), getHeight());
		gameLayer.add(backgroundPanel, new Integer(0));
		int width = 140;
		int height = 80;

		if(stage == 1)
		{
			AddChicken(new RedChicken(this, 0, 0, width, height), 0, 0);
			AddChicken(new BlueChicken(this, 1, 0, width, height), 1, 0);
			AddChicken(new YellowChicken(this, 2, 0, width, height), 2, 0);
			AddChicken(new RedChicken(this, 3, 0, width, height), 3, 0);
			AddChicken(new RedChicken(this, 4, 0, width, height), 4, 0);
			AddChicken(new YellowChicken(this, 5, 0, width, height), 5, 0);
			AddChicken(new BlueChicken(this, 6, 0, width, height), 6, 0);
			AddChicken(new RedChicken(this, 7, 0, width, height), 7, 0);
			AddChicken(new YellowChicken(this, 0, 1, width, height), 0, 1);
			AddChicken(new RedChicken(this, 1, 1, width, height), 1, 1);
			AddChicken(new BlueChicken(this, 2, 1, width, height), 2, 1);
			AddChicken(new BlueChicken(this, 3, 1, width, height), 3, 1);
			AddChicken(new BlueChicken(this, 4, 1, width, height), 4, 1);
			AddChicken(new BlueChicken(this, 5, 1, width, height), 5, 1);
			AddChicken(new RedChicken(this, 6, 1, width, height), 6, 1);
			AddChicken(new YellowChicken(this, 7, 1, width, height), 7, 1);
			AddChicken(new BlueChicken(this, 0, 2, width, height), 0, 2);
			AddChicken(new YellowChicken(this, 1, 2, width, height), 1, 2);
			AddChicken(new RedChicken(this, 2, 2, width, height), 2, 2);
			AddChicken(new YellowChicken(this, 3, 2, width, height), 3, 2);
			AddChicken(new YellowChicken(this, 4, 2, width, height), 4, 2);
			AddChicken(new RedChicken(this, 5, 2, width, height), 5, 2);
			AddChicken(new YellowChicken(this, 6, 2, width, height), 6, 2);
			AddChicken(new BlueChicken(this, 7, 2, width, height), 7, 2);
			AddChicken(new RedChicken(this, 0, 3, width, height), 0, 3);
			AddChicken(new BlueChicken(this, 1, 3, width, height), 1, 3);
			AddChicken(new YellowChicken(this, 2, 3, width, height), 2, 3);
			AddChicken(new OrangeChicken(this, 3, 3, width, height), 3, 3);
			AddChicken(new OrangeChicken(this, 4, 3, width, height), 4, 3);
			AddChicken(new YellowChicken(this, 5, 3, width, height), 5, 3);
			AddChicken(new BlueChicken(this, 6, 3, width, height), 6, 3);
			AddChicken(new RedChicken(this, 7, 3, width, height), 7, 3);
		}
		else if(stage == 2)
		{
			AddChicken(new PurpleChicken(this, 0, 0, width, height), 0, 0);
			AddChicken(new PurpleChicken(this, 1, 0, width, height), 1, 0);
			AddChicken(new PurpleChicken(this, 2, 0, width, height), 2, 0);
			AddChicken(new GreenChicken(this, 3, 0, width, height), 3, 0);
			AddChicken(new GreenChicken(this, 4, 0, width, height), 4, 0);
			AddChicken(new OrangeChicken(this, 5, 0, width, height), 5, 0);
			AddChicken(new OrangeChicken(this, 6, 0, width, height), 6, 0);
			AddChicken(new OrangeChicken(this, 7, 0, width, height), 7, 0);
			AddChicken(new YellowChicken(this, 0, 1, width, height), 0, 1);
			AddChicken(new CircleChicken(this, 1, 1, width, height), 1, 1);
			AddChicken(new RedChicken(this, 2, 1, width, height), 2, 1);
			AddChicken(new RedChicken(this, 3, 1, width, height), 3, 1);
			AddChicken(new RedChicken(this, 4, 1, width, height), 4, 1);
			AddChicken(new RedChicken(this, 5, 1, width, height), 5, 1);
			AddChicken(new CircleChicken(this, 6, 1, width, height), 6, 1);
			AddChicken(new YellowChicken(this, 7, 1, width, height), 7, 1);
			AddChicken(new YellowChicken(this, 0, 2, width, height), 0, 2);
			AddChicken(new RedChicken(this, 1, 2, width, height), 1, 2);
			AddChicken(new BlueChicken(this, 2, 2, width, height), 2, 2);
			AddChicken(new BlueChicken(this, 3, 2, width, height), 3, 2);
			AddChicken(new BlueChicken(this, 4, 2, width, height), 4, 2);
			AddChicken(new BlueChicken(this, 5, 2, width, height), 5, 2);
			AddChicken(new RedChicken(this, 6, 2, width, height), 6, 2);
			AddChicken(new YellowChicken(this, 7, 2, width, height), 7, 2);
			AddChicken(new GreenChicken(this, 0, 3, width, height), 0, 3);
			AddChicken(new PurpleChicken(this, 1, 3, width, height), 1, 3);
			AddChicken(new OrangeChicken(this, 2, 3, width, height), 2, 3);
			AddChicken(new YellowChicken(this, 3, 3, width, height), 3, 3);
			AddChicken(new YellowChicken(this, 4, 3, width, height), 4, 3);
			AddChicken(new OrangeChicken(this, 5, 3, width, height), 5, 3);
			AddChicken(new PurpleChicken(this, 6, 3, width, height), 6, 3);
			AddChicken(new GreenChicken(this, 7, 3, width, height), 7, 3);
		}
		else if(stage == 3)
		{
			AddChicken(new PurpleChicken(this, 0, 0, width, height), 0, 0);
			AddChicken(new PurpleChicken(this, 1, 0, width, height), 1, 0);
			AddChicken(new PurpleChicken(this, 2, 0, width, height), 2, 0);
			AddChicken(new YellowChicken(this, 3, 0, width, height), 3, 0);
			AddChicken(new YellowChicken(this, 4, 0, width, height), 4, 0);
			AddChicken(new OrangeChicken(this, 5, 0, width, height), 5, 0);
			AddChicken(new OrangeChicken(this, 6, 0, width, height), 6, 0);
			AddChicken(new OrangeChicken(this, 7, 0, width, height), 7, 0);
			AddChicken(new PurpleChicken(this, 0, 1, width, height), 0, 1);
			AddChicken(new PlusChicken(this, 1, 1, width, height), 1, 1);
			AddChicken(new PurpleChicken(this, 2, 1, width, height), 2, 1);
			AddChicken(new BlueChicken(this, 3, 1, width, height), 3, 1);
			AddChicken(new BlueChicken(this, 4, 1, width, height), 4, 1);
			AddChicken(new GreenChicken(this, 5, 1, width, height), 5, 1);
			AddChicken(new GreenChicken(this, 6, 1, width, height), 6, 1);
			AddChicken(new GreenChicken(this, 7, 1, width, height), 7, 1);
			AddChicken(new PurpleChicken(this, 0, 2, width, height), 0, 2);
			AddChicken(new PurpleChicken(this, 1, 2, width, height), 1, 2);
			AddChicken(new PurpleChicken(this, 2, 2, width, height), 2, 2);
			AddChicken(new RedChicken(this, 3, 2, width, height), 3, 2);
			AddChicken(new RedChicken(this, 4, 2, width, height), 4, 2);
			AddChicken(new GreenChicken(this, 5, 2, width, height), 5, 2);
			AddChicken(new PlusChicken(this, 6, 2, width, height), 6, 2);
			AddChicken(new GreenChicken(this, 7, 2, width, height), 7, 2);
			AddChicken(new OrangeChicken(this, 0, 3, width, height), 0, 3);
			AddChicken(new OrangeChicken(this, 1, 3, width, height), 1, 3);
			AddChicken(new OrangeChicken(this, 2, 3, width, height), 2, 3);
			AddChicken(new PlusChicken(this, 3, 3, width, height), 3, 3);
			AddChicken(new OrangeChicken(this, 4, 3, width, height), 4, 3);
			AddChicken(new GreenChicken(this, 5, 3, width, height), 5, 3);
			AddChicken(new GreenChicken(this, 6, 3, width, height), 6, 3);
			AddChicken(new GreenChicken(this, 7, 3, width, height), 7, 3);
		}
		else if(stage == 4)
		{
			AddChicken(new PurpleChicken(this, 0, 0, width, height), 0, 0);
			AddChicken(new PurpleChicken(this, 1, 0, width, height), 1, 0);
			AddChicken(new OrangeChicken(this, 2, 0, width, height), 2, 0);
			AddChicken(new OrangeChicken(this, 3, 0, width, height), 3, 0);
			AddChicken(new PurpleChicken(this, 4, 0, width, height), 4, 0);
			AddChicken(new PurpleChicken(this, 5, 0, width, height), 5, 0);
			AddChicken(new OrangeChicken(this, 6, 0, width, height), 6, 0);
			AddChicken(new OrangeChicken(this, 7, 0, width, height), 7, 0);
			AddChicken(new GreenChicken(this, 0, 1, width, height), 0, 1);
			AddChicken(new XChicken(this, 1, 1, width, height), 1, 1);
			AddChicken(new GreenChicken(this, 2, 1, width, height), 2, 1);
			AddChicken(new XChicken(this, 3, 1, width, height), 3, 1);
			AddChicken(new GreenChicken(this, 4, 1, width, height), 4, 1);
			AddChicken(new XChicken(this, 5, 1, width, height), 5, 1);
			AddChicken(new GreenChicken(this, 6, 1, width, height), 6, 1);
			AddChicken(new XChicken(this, 7, 1, width, height), 7, 1);
			AddChicken(new OrangeChicken(this, 0, 2, width, height), 0, 2);
			AddChicken(new YellowChicken(this, 1, 2, width, height), 1, 2);
			AddChicken(new PurpleChicken(this, 2, 2, width, height), 2, 2);
			AddChicken(new BlueChicken(this, 3, 2, width, height), 3, 2);
			AddChicken(new OrangeChicken(this, 4, 2, width, height), 4, 2);
			AddChicken(new YellowChicken(this, 5, 2, width, height), 5, 2);
			AddChicken(new PurpleChicken(this, 6, 2, width, height), 6, 2);
			AddChicken(new BlueChicken(this, 7, 2, width, height), 7, 2);
			AddChicken(new RedChicken(this, 0, 3, width, height), 0, 3);
			AddChicken(new RedChicken(this, 1, 3, width, height), 1, 3);
			AddChicken(new RedChicken(this, 2, 3, width, height), 2, 3);
			AddChicken(new RedChicken(this, 3, 3, width, height), 3, 3);
			AddChicken(new RedChicken(this, 4, 3, width, height), 4, 3);
			AddChicken(new RedChicken(this, 5, 3, width, height), 5, 3);
			AddChicken(new RedChicken(this, 6, 3, width, height), 6, 3);
			AddChicken(new RedChicken(this, 7, 3, width, height), 7, 3);
		}
		else if(stage == 5)
		{
			AddChicken(new PurpleChicken(this, 0, 0, width, height), 0, 0);
			AddChicken(new PurpleChicken(this, 1, 0, width, height), 1, 0);
			AddChicken(new OrangeChicken(this, 2, 0, width, height), 2, 0);
			AddChicken(new OrangeChicken(this, 3, 0, width, height), 3, 0);
			AddChicken(new RowChicken(this, 4, 0, width, height), 4, 0);
			AddChicken(new ColumnChicken(this, 5, 0, width, height), 5, 0);
			AddChicken(new OrangeChicken(this, 6, 0, width, height), 6, 0);
			AddChicken(new OrangeChicken(this, 7, 0, width, height), 7, 0);
			AddChicken(new GreenChicken(this, 0, 1, width, height), 0, 1);
			AddChicken(new XChicken(this, 1, 1, width, height), 1, 1);
			AddChicken(new GreenChicken(this, 2, 1, width, height), 2, 1);
			AddChicken(new XChicken(this, 3, 1, width, height), 3, 1);
			AddChicken(new GreenChicken(this, 4, 1, width, height), 4, 1);
			AddChicken(new XChicken(this, 5, 1, width, height), 5, 1);
			AddChicken(new GreenChicken(this, 6, 1, width, height), 6, 1);
			AddChicken(new XChicken(this, 7, 1, width, height), 7, 1);
			AddChicken(new OrangeChicken(this, 0, 2, width, height), 0, 2);
			AddChicken(new YellowChicken(this, 1, 2, width, height), 1, 2);
			AddChicken(new PurpleChicken(this, 2, 2, width, height), 2, 2);
			AddChicken(new BlueChicken(this, 3, 2, width, height), 3, 2);
			AddChicken(new RowChicken(this, 4, 2, width, height), 4, 2);
			AddChicken(new YellowChicken(this, 5, 2, width, height), 5, 2);
			AddChicken(new PurpleChicken(this, 6, 2, width, height), 6, 2);
			AddChicken(new BlueChicken(this, 7, 2, width, height), 7, 2);
			AddChicken(new RedChicken(this, 0, 3, width, height), 0, 3);
			AddChicken(new ColumnChicken(this, 1, 3, width, height), 1, 3);
			AddChicken(new RedChicken(this, 2, 3, width, height), 2, 3);
			AddChicken(new RedChicken(this, 3, 3, width, height), 3, 3);
			AddChicken(new ColumnChicken(this, 4, 3, width, height), 4, 3);
			AddChicken(new RedChicken(this, 5, 3, width, height), 5, 3);
			AddChicken(new RowChicken(this, 6, 3, width, height), 6, 3);
			AddChicken(new RedChicken(this, 7, 3, width, height), 7, 3);
		}
		else if(stage == 6)
		{
			AddChicken(new PurpleChicken(this, 0, 0, width, height), 0, 0);
			AddChicken(new PlusChicken(this, 1, 0, width, height), 1, 0);
			AddChicken(new RowChicken(this, 2, 0, width, height), 2, 0);
			AddChicken(new GreenChicken(this, 3, 0, width, height), 3, 0);
			AddChicken(new XChicken(this, 4, 0, width, height), 4, 0);
			AddChicken(new XorChicken	(this, 5, 0, width, height), 5, 0);
			AddChicken(new ColumnChicken(this, 6, 0, width, height), 6, 0);
			AddChicken(new OrangeChicken(this, 7, 0, width, height), 7, 0);
			AddChicken(new YellowChicken(this, 0, 1, width, height), 0, 1);
			AddChicken(new FluChicken(this, 1, 1, width, height), 1, 1);
			AddChicken(new RedChicken(this, 2, 1, width, height), 2, 1);
			AddChicken(new RedChicken(this, 3, 1, width, height), 3, 1);
			AddChicken(new RowChicken(this, 4, 1, width, height), 4, 1);
			AddChicken(new CircleChicken(this, 5, 1, width, height), 5, 1);
			AddChicken(new CircleChicken(this, 6, 1, width, height), 6, 1);
			AddChicken(new FluChicken(this, 7, 1, width, height), 7, 1);
			AddChicken(new PlusChicken(this, 0, 2, width, height), 0, 2);
			AddChicken(new RedChicken(this, 1, 2, width, height), 1, 2);
			AddChicken(new BlueChicken(this, 2, 2, width, height), 2, 2);
			AddChicken(new XorChicken(this, 3, 2, width, height), 3, 2);
			AddChicken(new BlueChicken(this, 4, 2, width, height), 4, 2);
			AddChicken(new BlueChicken(this, 5, 2, width, height), 5, 2);
			AddChicken(new RedChicken(this, 6, 2, width, height), 6, 2);
			AddChicken(new YellowChicken(this, 7, 2, width, height), 7, 2);
			AddChicken(new GreenChicken(this, 0, 3, width, height), 0, 3);
			AddChicken(new XChicken(this, 1, 3, width, height), 1, 3);
			AddChicken(new CircleChicken(this, 2, 3, width, height), 2, 3);
			AddChicken(new XorChicken(this, 3, 3, width, height), 3, 3);
			AddChicken(new ColumnChicken(this, 4, 3, width, height), 4, 3);
			AddChicken(new OrangeChicken(this, 5, 3, width, height), 5, 3);
			AddChicken(new XorChicken(this, 6, 3, width, height), 6, 3);
			AddChicken(new RowChicken(this, 7, 3, width, height), 7, 3);
		}

		spaceship = new Spaceship();
		gameLayer.add(spaceship,new Integer(3));
		spaceship.setBounds(625, 700, 100, 100);
		addKeyListener(this);

		timerShot = new Timer(20, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!shotIsDead)
				{
					for(Chicken chicken : chickensList)
					{
						if(!shotIsDead && shot.getLocation().getX() <= chicken.getLocation().getX() + chicken.getPreferredSize().getWidth() && shot.getLocation().getX() + shot.getPreferredSize().getWidth() >= chicken.getLocation().getX() && shot.getLocation().getY() <= chicken.getLocation().getY() + chicken.getPreferredSize().getHeight() && shot.getLocation().getY() + shot.getPreferredSize().getHeight() >= chicken.getLocation().getY())
						{
							shot.shooting(chicken);
							removeShot();
							break;
						}
						if(shot.getLocation().getY() <= -10)
							break;
					}

					if(shot.getLocation().getY() <= -10)
						removeShot();

					if(!shotIsDead)
					{
						shotAccelerator -= 3;
						shot.setLocation(shot.getX(), shot.getY() + shotAccelerator);
					}
					else
						shotAccelerator = 0;
				}
				if(chickensList.isEmpty())
					StageCleared();
			}
		});
		timerShot.start();

		countTimeTimer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timeCountLabel.setText("Time: " + (System.currentTimeMillis() - timeCount) / 1000);
			}
		});
		countTimeTimer.start();

		BorderLayout boardLayout = new BorderLayout();
		JPanel boardPanel = new JPanel(boardLayout);
		boardPanel.add(topPanel, BorderLayout.NORTH);
		boardPanel.add(gameLayer, BorderLayout.CENTER);

		timeCount = System.currentTimeMillis();

		add(boardPanel);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private int accelerator = 0;
	private int shotAccelerator = 0;

	

	@Override
	public void keyPressed(KeyEvent arg0) {
		//Spaceship accelerator
		switch(arg0.getKeyCode())
		{
		case KeyEvent.VK_LEFT:
			if( accelerator != -100)
				accelerator -= 2;
			if (spaceship.getX() + accelerator > 60)
				spaceship.setLocation(spaceship.getX() + accelerator, spaceship.getY());
			else
				spaceship.setLocation(60, spaceship.getY());
			break;

		case KeyEvent.VK_RIGHT:
			if( accelerator != 100)
				accelerator += 2;
			if (spaceship.getX() + accelerator < 1160)
				spaceship.setLocation(spaceship.getX() + accelerator, spaceship.getY());
			else
				spaceship.setLocation(1160, spaceship.getY());
			break;

		case KeyEvent.VK_SPACE:
			if(shotIsDead)
			{
				if(nextShot != null)
				{
					shot = nextShot;
					nextShot = null;
				}
				shotIsDead = false;
				gameLayer.add(shot, new Integer(2));
				shot.setBounds(spaceship.getX() + (int) (spaceship.getPreferredSize().getWidth() / 2 - 7), spaceship.getY() - 33, 100, 100);
				shotsCountLabel.setText("Number of shots: " + ++shotsCount);
			}
			break;
		case KeyEvent.VK_1:
		case KeyEvent.VK_NUMPAD1:
			nextShot = new BlackShot();
			break;
		case KeyEvent.VK_2:
		case KeyEvent.VK_NUMPAD2:
			nextShot = new RedShot();
			break;
		case KeyEvent.VK_3:
		case KeyEvent.VK_NUMPAD3:
			nextShot = new BlueShot();
			break;
		case KeyEvent.VK_4:
		case KeyEvent.VK_NUMPAD4:
			nextShot = new YellowShot();
			break;				
		}
	}

	public void DestroyRow(int row)
	{
		for (int i = 0; i < 8; i++)
			if(chickens[i][row] != null)
				chickens[i][row].die();
	}

	public void DestroyColumn(int column)
	{
		for (int i = 0; i < 4; i++)
			if(chickens[column][i] != null)
				chickens[column][i].die();
	}

	public void DestroyX(int column, int row)
	{
		// up-left
		for (int i = 1; column - i >= 0 && row - i >= 0; i++)
			if(chickens[column - i][row - i] != null)
				chickens[column - i][row - i].die();

		// up-right
		for (int i = 1; column + i <= 7 && row - i >= 0; i++)
			if(chickens[column + i][row - i] != null)
				chickens[column + i][row - i].die();

		// down-left
		for (int i = 1; column - i >= 0 && row + i <= 3; i++)
			if(chickens[column - i][row + i] != null)
				chickens[column - i][row + i].die();

		// down-right
		for (int i = 1; column + i <= 7 && row + i <= 3; i++)
			if(chickens[column + i][row + i] != null)
				chickens[column + i][row + i].die();

		// kill itself
		chickens[column][row].die();
	}

	public void DestroyCircle(int column, int row)
	{
		if(column - 1 >= 0 && row - 1 >= 0 && chickens[column - 1][row - 1] != null)
			chickens[column - 1][row - 1].die();
		if(column - 1 >= 0 && chickens[column - 1][row] != null)
			chickens[column - 1][row].die();
		if(column - 1 >= 0 && row + 1 <= 3 && chickens[column - 1][row + 1] != null)
			chickens[column - 1][row + 1].die();
		if(row - 1 >= 0 && chickens[column][row - 1] != null)
			chickens[column][row - 1].die();
		if(row + 1 <= 3 && chickens[column][row + 1] != null)
			chickens[column][row + 1].die();
		if(column + 1 <= 7 && row - 1 >= 0 && chickens[column + 1][row - 1] != null)
			chickens[column + 1][row - 1].die();
		if(column + 1 >= 0 && chickens[column + 1][row] != null)
			chickens[column + 1][row].die();
		if(column + 1 <= 7 && row + 1 <= 3 && chickens[column + 1][row + 1] != null)
			chickens[column + 1][row + 1].die();

		chickens[column][row].die();
	}

	public void removeChicken(Chicken chicken)
	{
		gameLayer.remove(chicken);
		revalidate();
		repaint();
	}

	public void removeShot()
	{
		gameLayer.remove(shot);
		revalidate();
		repaint();
		shotIsDead = true;
	}

	public void StageCleared()
	{
		long currentTime = System.currentTimeMillis();
		countTimeTimer.stop();
		if(timerShot.isRunning())
			timerShot.stop();
		if(stage < 6)
		{
			String totalScore = String.valueOf((grade + Math.max(0, 600 - shotsCount*10 - ((currentTime - timeCount) / 1000))));
			String scoreThisLevel = String.valueOf(Math.max(0, 600 - shotsCount*10 - ((currentTime - timeCount) / 1000)));

			String[] options = {"OK"};
			JPanel panel = new JPanel(new GridLayout(6,1));
			JLabel scoreThisLevelLabel = new JLabel("The score you've got on this stage is: " + scoreThisLevel);
			JLabel totalScoreLabel = new JLabel("Your total score is: " + totalScore);
			JLabel totalShotsLabel = new JLabel("Number of shots is: " + shotsCount);
			JLabel totalTimeLabel = new JLabel("The time it took you is: " + ((currentTime - timeCount) / 1000));
			panel.add(scoreThisLevelLabel);
			panel.add(totalScoreLabel);
			panel.add(totalShotsLabel);
			panel.add(totalTimeLabel);
			JOptionPane.showOptionDialog(null, panel, "You won the stage", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);
			dispose();
			new GameBoard(stage + 1, (int)(grade + Math.max(0, 600 - shotsCount*10 - ((currentTime - timeCount) / 1000))));
		}
		else
		{
			String totalScore = String.valueOf((grade + Math.max(0, 600 - shotsCount*10 - ((currentTime - timeCount) / 1000))));
			String scoreThisLevel = String.valueOf(Math.max(0, 600 - shotsCount*10 - ((currentTime - timeCount) / 1000)));

			String[] options = {"OK"};
			JPanel panel = new JPanel(new GridLayout(5,1));
			JLabel scoreThisLevelLabel = new JLabel("The score you've got on this stage is: " + scoreThisLevel);
			JLabel totalScoreLabel = new JLabel("Your total score is: " + totalScore);
			JLabel totalShotsLabel = new JLabel("Number of shots is: " + shotsCount);
			JLabel totalTimeLabel = new JLabel("The time it took you is: " + ((currentTime - timeCount) / 1000));
			JLabel lbl = new JLabel("Enter Your name: ");
			JTextField name = new JTextField(10);
			panel.add(scoreThisLevelLabel);
			panel.add(totalScoreLabel);
			panel.add(totalShotsLabel);
			panel.add(totalTimeLabel);
			panel.add(lbl);
			panel.add(name);
			int selectedOption = JOptionPane.showOptionDialog(null, panel, "You won the game!!", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);
			if (selectedOption == JOptionPane.CLOSED_OPTION)
				dispose();
			else
			{
				String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
				if (!name.getText().equals(""))
					new DiskHandler(name.getText(), totalScore, timeStamp);
				else
					new DiskHandler("Anonymous", totalScore, timeStamp);
				dispose();
				new MainMenu();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		accelerator = 0;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	private void AddChicken(Chicken chicken, int i, int j)
	{
		chicken.setBounds((int) (i*(chicken.getWidth() + 10) + 50), (int) (j*(chicken.getHeight() + 10) + 50), chicken.getWidth(), chicken.getHeight());
		gameLayer.add(chicken, new Integer(1));
		chickensList.add(chicken);
	}

	public List<OrangeChicken> getOrangeChickensList() {
		return orangeChickensList;
	}

	public List<Chicken> getChickensList() {
		return chickensList;
	}

	public void setChickensList(List<Chicken> chickensList) {
		this.chickensList = chickensList;
	}

	public void setOrangeChickensList(List<OrangeChicken> orangeChickensList) {
		this.orangeChickensList = orangeChickensList;
	}

	public List<GreenChicken> getGreenChickensList() {
		return greenChickensList;
	}

	public void setGreenChickensList(List<GreenChicken> greenChickensList) {
		this.greenChickensList = greenChickensList;
	}

	public List<PurpleChicken> getPurpleChickensList() {
		return purpleChickensList;
	}

	public void setPurpleChickensList(List<PurpleChicken> purpleChickensList) {
		this.purpleChickensList = purpleChickensList;
	}

	public Chicken[][] getChickens() {
		return chickens;
	}

	public void setChickens(Chicken[][] chickens) {
		this.chickens = chickens;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
}

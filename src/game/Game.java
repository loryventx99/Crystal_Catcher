package game;

import components.*;
import levels.Level1;
import util.GetPath;

import javax.swing.*;
import java.awt.event.*;

public class Game extends JFrame {
	private MoneyCounter moneyCounter;
	private Hearts hearts;
	private Player player;
	private Level1 l1;
	private final int width = 800, height = 600, widthLabel = 2400;
	private JLayeredPane jl;
	private final Object monitor;
	private int vx = 10;
	Component blocco;
	private Thread playerThread;



	public Game() {
		//inizializzazione JFrame
		super("Crystal Catcher");
		setupJFrame();

		//creazione componenti
		moneyCounter = new MoneyCounter(width - 150, 0, 150, 55, 0);
		hearts = new Hearts(0, 0, 140, 55, 3);
		l1 = new Level1();
		jl = new JLayeredPane();
		monitor = new Object();

		//setup componenti
		setupPlayer();
		setupJLayeredPane();
		//setupCollision();
		playerThread = new Thread(player, "Player Thread");
		playerThread.start();

		this.setVisible(true);
	}

	private void setupJFrame() {
		this.setIconImage(new ImageIcon(GetPath.LOGO).getImage());
		this.setSize(width, height);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				int bg_x = l1.getLocation().x;

				switch (e.getKeyCode()) {
					case KeyEvent.VK_D:
					case KeyEvent.VK_RIGHT:
						if (bg_x > -widthLabel + width) bg_x -= vx;
						break;
					case KeyEvent.VK_A:
					case KeyEvent.VK_LEFT:
						if (bg_x < 0) bg_x += vx;
						break;
					case KeyEvent.VK_SPACE:
						synchronized (monitor) {
							if (!player.isJumping()) monitor.notify();
						}
						break;
				}
				l1.setBounds(bg_x, 0, widthLabel, height);
				System.out.println("bg_x: " + bg_x);
			}
		});
	}

	private void setupPlayer() {
		player = new Player(120, 425, monitor, l1.getPlatforms());
		this.add(player);
	}

	private void setupJLayeredPane() {
		jl.setBounds(0, 0, width, height);
		jl.add(l1, JLayeredPane.DEFAULT_LAYER);
		jl.add(hearts, JLayeredPane.PALETTE_LAYER);
		jl.add(moneyCounter, JLayeredPane.PALETTE_LAYER);
		moneyCounter.setBounds(width - moneyCounter.getWidth(), 0, moneyCounter.getWidth(), moneyCounter.getWidth());

		this.add(jl);
	}

	/*private void setupCollision() {

		for (Component platform : l1.getPlatforms()) {
			if (player.getVy().y + width > platform.getLocation().y //verifica che sia in una posizione maggiore del limite sinistro della piattaforma
					&& player.getLocation().x < platform.getLocation().x + platform.getWidth() //verifica che sia in una posizione maggiore del limite sinistro della piattaforma
					&& player.getLocation().y + height > platform.getLocation().y
					&& player.getLocation().y + height - player.getVy().y <= platform.getLocation().y) {
				player.getLocation().y = platform.getLocation().y - height;
				player.getVy().y = 0;
				player.onGround = true;
				System.out.print("cazzi giganti");
			}

		}
	}*/
}
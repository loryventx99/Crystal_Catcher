package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class Game2 extends JPanel implements ActionListener, KeyListener {
	private static final int SCREEN_WIDTH = 800;
	private static final int SCREEN_HEIGHT = 600;

	private static final int PLAYER_WIDTH = 50;
	private static final int PLAYER_HEIGHT = 50;
	private static final Color PLAYER_COLOR = Color.RED;
	private static final double GRAVITY = 0.5;
	private static final double JUMP_STRENGTH = -10;
	private static final double MOVE_SPEED = 5;
	private boolean movingLeft = false;
	private boolean movingRight = false;

	private Timer timer;
	private double playerX = SCREEN_WIDTH / 2 - PLAYER_WIDTH / 2;
	private double playerY = SCREEN_HEIGHT - PLAYER_HEIGHT;
	private double velocityY = 0;
	private boolean onGround = false;

	private List<Platform> platforms;

	public Game2() {
		setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		setFocusable(true);
		addKeyListener(this);

		platforms = new ArrayList<>();
		platforms.add(new Platform(150, 400, 200, 10));
		platforms.add(new Platform(400, 300, 150, 10));
		platforms.add(new Platform(600, 450, 200, 10));

		timer = new Timer(16, this);
		timer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(PLAYER_COLOR);
		g.fillRect((int) playerX, (int) playerY, PLAYER_WIDTH, PLAYER_HEIGHT);

		g.setColor(Color.BLACK);
		for (Platform platform : platforms) {
			g.fillRect(platform.x, platform.y, platform.width, platform.height);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		updatePlayer();
		repaint();
	}

	private void updatePlayer() {
		velocityY += GRAVITY;
		playerY += velocityY;

		if (playerY + PLAYER_HEIGHT >= SCREEN_HEIGHT) {
			playerY = SCREEN_HEIGHT - PLAYER_HEIGHT;
			velocityY = 0;
			onGround = true;
		} else {
			onGround = false;
		}

		for (Platform platform : platforms) {
			if (playerX + PLAYER_WIDTH > platform.x //verifica che sia in una posizione maggiore del limite sinistro della piattaforma
					&& playerX < platform.x + platform.width //verifica che sia in una posizione maggiore del limite sinistro della piattaforma
					&& playerY + PLAYER_HEIGHT > platform.y
					&& playerY + PLAYER_HEIGHT - velocityY <= platform.y) {
				playerY = platform.y - PLAYER_HEIGHT;
				velocityY = 0;
				onGround = true;
			}
		}

		if (movingRight) {
			playerX += MOVE_SPEED;
		}
		if (movingLeft) {
			playerX -= MOVE_SPEED;
		}

		if (playerX < 0) {
			playerX = 0;
		} else if (playerX + PLAYER_WIDTH > SCREEN_WIDTH) {
			playerX = SCREEN_WIDTH - PLAYER_WIDTH;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE && onGround) {
			velocityY = JUMP_STRENGTH;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			movingRight = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			movingLeft = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			movingRight = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			movingLeft = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Mario Game");
		Game2 game = new Game2();
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	class Platform {
		int x, y, width, height;

		Platform(int x, int y, int width, int height) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}
	}
}
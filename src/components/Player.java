package components;

import util.GetPath;
import util.Util;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Player extends Component implements Runnable {
	//private static ImageIcon[] images; //= Util.initializeImageIconArray(GetPath.PLAYER, 6);
	private static final ImageIcon image = Util.getImageWithoutBackgroundAndScale(GetPath.PLAYER, 90, 70);
	private final Object monitor;
	private boolean jumping;
	public boolean onGround;
	private ArrayList<Component> platforms;

	public Player(int posX, int posY, Object monitor, ArrayList<Component> platforms) {
		super(posX, posY, image);
		this.monitor = monitor;
		this.jumping = false;
		this.platforms = platforms;
	}

	private synchronized void jump() {
		jumping = true;
		onGround = false;

		var vy = new Object() {
			public int vy = -15;
		};
		Point p = this.getLocation();
		Timer timer = new Timer(20, null);

		timer.addActionListener(e -> { //bisogna gestire l'atterraggio dopo il salto senno' cade all'infinito
			System.out.println("player x,y " + p.x + ", " + p.y);
			p.y += vy.vy++;
			this.setBounds(p.x, p.y, image.getIconWidth(), image.getIconHeight());

			int y = checkCollisionY();

			//condizione per interrompere il salto
			if (onGround) {
				timer.stop();
				jumping = false;
				this.setBounds(p.x, y - this.getHeight(), image.getIconWidth(), image.getIconHeight());
			}
		});

		timer.start();
	}

	private void move() {
		// da fare l'animazione della corsa
	}

	private void fall() {
		// da fare l'animazione della caduta da una piattaforma
	}

	private void checkfall() {
		// controllo caduta da piattaforma
	}

	public int checkCollisionY() {
		Point t = this.getLocation();
		Point cp;

		for (Component c : platforms) {
			cp = c.getLocation();

			// check along X axis
			if (!(cp.x <= t.x && cp.x + c.getWidth() >= t.x + this.getWidth())) {
				break;
			}

			// check collision along Y axis
			if (cp.y <= t.y + this.getHeight()) {
				onGround = true;
				return cp.y;
			}
		}

		return -1;
	}

	@Override
	public void run() {
		synchronized (monitor) {
			try {
				while (true) {
					monitor.wait();
					jump();
				}
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}
}
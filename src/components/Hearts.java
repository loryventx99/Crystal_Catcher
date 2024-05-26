package components;

import javax.swing.JPanel;
import java.awt.GridLayout;

/**
 * A custom JPanel that represents a collection of Heart components.
 * It arranges the hearts in a horizontal layout.
 *
 * @author Lorenzo Venturino
 * @version 1.0
 */
public class Hearts extends JPanel {
	private Heart[] hearts;
	private int count;

	/**
	 * Constructs a new Hearts instance.
	 *
	 * @param width  The width of the panel.
	 * @param height The height of the panel.
	 * @param n      The number of hearts to be displayed.
	 */
	public Hearts(int width, int height, int n) {
		hearts = new Heart[n];
		count = n;

		this.setSize(width, height);
		this.setLayout(new GridLayout(1, n));
		this.setBackground(null);

		for (int i = 0; i < hearts.length; i++) {
			hearts[i] = new Heart();
			this.add(hearts[i]);
		}
	}

	/**
	 * Decrements the number of visible hearts by one, making them invisible.
	 */
	public void decrementHearts() {
		if (count > 0) {
			hearts[--count].setVisible(false);
		}
	}

	/**
	 * Returns the number of visible hearts in the panel.
	 *
	 * @return The number of visible hearts.
	 */
	public int getHeartsCount() {
		return count;
	}
}
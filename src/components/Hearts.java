package components;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;

/**
 * A custom {@code JPanel} that represents a collection of {@code Heart} components.
 * It arranges the hearts in a horizontal layout.
 *
 * @author Lorenzo Venturino
 * @version 1.0
 */
public class Hearts extends JPanel {
	private Heart[] hearts;
	private int count;

	/**
	 * Constructs a new {@code Hearts} instance.
	 *
	 * @param width  The width of the panel.
	 * @param height The height of the panel.
	 * @param n      The number of hearts to be displayed.
	 */
	public Hearts(int x, int y, int width, int height, int n) {
		hearts = new Heart[n];
		count = n;

		//setup JPanel
		this.setBounds(x, y, width, height);
		this.setLayout(new GridLayout(1, n));
		this.setBackground(new Color(0, 0, 0, 0));

		//setup hearts: creation and adding to the JPanel
		for (int i = 0; i < hearts.length; i++) {
			hearts[i] = new Heart();
			this.add(hearts[i]);
		}
	}

	/**
	 * Decrements the number of visible hearts by one, making them invisible.
	 */
	public void decrementHearts() {
		if (count > 0) hearts[--count].setVisible(false);
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
package components;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import util.GetPath;
import util.Util;

/**
 * A custom JPanel that represents a money counter.
 * It displays a crystal and the crystal counter.
 *
 * @author Lorenzo Venturino
 * @version 1.0
 */
public class MoneyCounter extends JPanel {
	private int count;
	private JLabel label;

	/**
	 * Constructs a new MoneyCounter with the specified width and height.
	 *
	 * @param width  the width of the MoneyCounter
	 * @param height the height of the MoneyCounter
	 * @param count  the initial count of the MoneyCounter.
	 */
	public MoneyCounter(int width, int height, int count) {
		this.count = count;

		label = new JLabel(Integer.toString(count));
		label.setIcon(Util.getImageWithoutBackground(GetPath.HEART));
		//bisogna scegliere un font per il gioco
		label.setFont(new Font(null, Font.PLAIN, 22));
		label.setForeground(Color.WHITE);

		this.setSize(width, height);
		this.setLayout(new FlowLayout());
		this.setBackground(null);
		this.add(label);
	}

	/**
	 * Increments the count by 1 and updates the label text.
	 */
	public void increment() {
		count++;
		label.setText(Integer.toString(count));
	}

	/**
	 * Returns the current count.
	 *
	 * @return the current count
	 */
	public int getCount() {
		return count;
	}
}
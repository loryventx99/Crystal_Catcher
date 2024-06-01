package components;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import util.GetPath;
import util.Util;

/**
 * A custom {@code JPanel} that represents a money counter.
 * It displays a crystal and the crystal counter.
 *
 * @author Lorenzo Venturino
 * @version 1.1
 */
public class MoneyCounter extends JPanel {
	private int count;
	private JLabel label;

	/**
	 * Constructs a new {@code MoneyCounter} with the specified width and height.
	 *
	 * @param width  the width of the MoneyCounter
	 * @param height the height of the MoneyCounter
	 * @param count  the initial count of the MoneyCounter.
	 */
	public MoneyCounter(int x, int y, int width, int height, int count) {
		this.count = count;

		//setup JLabel
		label = new JLabel(Integer.toString(count));
		label.setIcon(Util.getImageWithoutBackgroundAndScale(GetPath.CRYSTAL_SMALL, 45, 60));
		label.setForeground(Color.WHITE);
		try {
			//setup custom font
			Font customFont = Font.createFont(Font.PLAIN, new File(GetPath.CUSTOM_FONT));
			customFont = customFont.deriveFont(32f);
			label.setFont(customFont);
		} catch (FontFormatException | IOException e) {
			throw new RuntimeException(e);
		}

		//setup JPanel
		this.setBounds(x, y, width, height);
		this.setLayout(new FlowLayout());
		this.setBackground(new Color(0, 0, 0, 0));
		this.add(label);
	}

	/**
	 * Increments the count by 1 and updates the label text.
	 */
	public void increment() {
		label.setText(Integer.toString(++count));
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
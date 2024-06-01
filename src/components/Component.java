package components;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;

/**
 * This class represents a custom component that extends a {@code JLabel} and displays an image.
 *
 * @author Lorenzo Venturino
 * @version 1.0
 */
public class Component extends JLabel {
	/**
	 * Constructs a new {@code Component} with the specified image.
	 * The size of the component will be set to the dimensions of the image.
	 *
	 * @param image The image to be displayed in the component.
	 */
	public Component(int x, int y, ImageIcon image) {
		this.setBounds(x, y, image.getIconWidth(), image.getIconHeight());
		this.setIcon(image);
		this.setBorder(BorderFactory.createLineBorder(Color.RED, 2)); // debug
	}
}
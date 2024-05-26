package components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * This class represents a custom component that extends JLabel and displays an image.
 *
 * @author Lorenzo Venturino
 * @version 1.0
 */
public class Component extends JLabel {
	/**
	 * Constructs a new Component with the specified image.
	 * The size of the component will be set to the dimensions of the image.
	 *
	 * @param image The image to be displayed in the component.
	 */
	public Component(ImageIcon image) {
		this.setSize(image.getIconWidth(), image.getIconHeight());
		this.setIcon(image);
	}
}
package components;

import util.GetPath;
import util.Util;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * This class represents a graphical heart component.
 * It extends JLabel and uses an image from the specified path.
 * The image is loaded using the Util.getImageWithoutBackground method,
 * and JLabel's size is set to match the image's dimensions.
 *
 * @author Lorenzo Venturino
 * @version 1.0
 */
public class Heart extends JLabel {
	private static ImageIcon image = Util.getImageWithoutBackground(GetPath.HEART);

	/**
	 * Constructs a new Heart object.
	 * The heart image is set as the icon of the JLabel,
	 * and JLabel's size is set to match the image's dimensions.
	 */
	public Heart() {
		this.setSize(image.getIconWidth(), image.getIconHeight());
		this.setIcon(image);
	}
}
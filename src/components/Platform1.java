package components;

import util.GetPath;
import util.Util;

import javax.swing.ImageIcon;

/**
 * Represents one of the platform components of the game that extends the {@code Component} class.
 *
 * @author Gabriele Andreani
 * @version 1.0
 * @see Component
 */
public class Platform1 extends Component {
	private static ImageIcon image = Util.getImageWithoutBackgroundAndScale(GetPath.PLATFORM_1, 100, 35);

	/**
	 * Constructor for the {@code Platform1} class.
	 * Initializes the platform object with the given x and y coordinates.
	 *
	 * @param x the x-coordinate of the platform
	 * @param y the y-coordinate of the platform
	 */
	public Platform1(int x, int y) {
		super(x, y, image);
	}
}
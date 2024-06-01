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
public class Platform3 extends Component {
	private static final ImageIcon image = Util.getImageWithoutBackgroundAndScale(GetPath.PLATFORM_3, 140, 35);

	/**
	 * Constructor for the {@code Platform3} class.
	 * Initializes the platform object with the given x and y coordinates.
	 *
	 * @param x the x-coordinate of the platform
	 * @param y the y-coordinate of the platform
	 */
	public Platform3(int x, int y) {
		super(x, y, image);
	}
}
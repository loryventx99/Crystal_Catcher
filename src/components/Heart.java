package components;

import util.GetPath;
import util.Util;

import javax.swing.ImageIcon;

/**
 * Represents a Heart component of the game that extends the {@code Component} class.
 *
 * @author Lorenzo Venturino
 * @version 1.0
 * @see Component
 */
public class Heart extends Component {
	private static final ImageIcon image = Util.getImageWithoutBackgroundAndScale(GetPath.HEART, 45, 45);

	/**
	 * Constructs a new {@code Heart} component initializing it with the loaded image.
	 */
	public Heart() {
		super(0, 0, image);
	}
}
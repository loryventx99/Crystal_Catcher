package components;

import util.GetPath;

import javax.swing.ImageIcon;

/**
 * This class represents a small background component of the game that extends the {@code Component} class.
 *
 * @author Lorenzo Venturino
 * @version 1.0
 * @see Component
 */
public class BackgroundSmall extends Component {
	private static final ImageIcon image = new ImageIcon(GetPath.BACKGROUND_SMALL);

	/**
	 * Constructs a new {@code BackgroundSmall} component initializing it with the loaded image.
	 */
	public BackgroundSmall() {
		super(0, 0, image);
	}
}
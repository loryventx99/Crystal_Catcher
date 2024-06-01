package components;

import util.GetPath;
import util.Util;

import javax.swing.ImageIcon;

/**
 * Represents a Crystal component of the game that extends the {@code Component} class.
 *
 * @author Lorenzo Venturino
 * @author Gabriele Andreani
 * @version 1.1
 * @see Component
 */
public class Crystal extends Component {
	private static final ImageIcon image = Util.getImageWithoutBackgroundAndScale(GetPath.CRYSTAL, 50, 35);

	/**
	 * Constructs a new {@code Crystal} component initializing it with the loaded image.
	 */
	public Crystal(int x, int y) {
		super(x, y, image);
	}

	public void caught() {
		this.setVisible(false);
	}
}
package components;

import util.GetPath;
import util.Util;

import javax.swing.ImageIcon;

/**
 * Represents a Crystal component in the game.
 * It extends the Component class and uses an image from the util package.
 *
 * @author Lorenzo Venturino
 * @version 1.1
 */
public class Crystal extends Component {
	private static final ImageIcon image = Util.getImageWithoutBackground(GetPath.CRYSTAL);

	/**
	 * Constructs a new Crystal component.
	 * It initializes the Crystal component with the loaded image.
	 */
	public Crystal() {
		super(image);
	}
}
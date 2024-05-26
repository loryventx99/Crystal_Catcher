package components;

import util.GetPath;
import util.Util;

import javax.swing.ImageIcon;

/**
 * Represents a Heart component with an image.
 *
 * @author Lorenzo Venturino
 * @version 1.1
 */
public class Heart extends Component {
	private static final ImageIcon image = Util.getImageWithoutBackground(GetPath.HEART);

	/**
	 * Constructs a new Heart component.
	 * It initializes the Heart component with the loaded image.
	 */
	public Heart() {
		super(image);
	}
}
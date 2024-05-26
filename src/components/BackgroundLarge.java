package components;

import util.GetPath;

import javax.swing.ImageIcon;

/**
 * This class represents a large background component.
 *
 * @author Lorenzo Venturino
 * @version 1.1
 */
public class BackgroundLarge extends Component {
	private static final ImageIcon image = new ImageIcon(GetPath.BACKGROUND_LARGE);

	/**
	 * Constructs a new BackgroundLarge component.
	 * It initializes the BackgroundLarge component with the loaded image.
	 */
	public BackgroundLarge() {
		super(image);
	}
}
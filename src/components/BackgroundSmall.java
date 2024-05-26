package components;

import util.GetPath;

import javax.swing.ImageIcon;

/**
 * This class represents a small background component.
 *
 * @author Lorenzo Venturino
 * @version 1.1
 */
public class BackgroundSmall extends Component {
	private static final ImageIcon image = new ImageIcon(GetPath.BACKGROUND_SMALL);

	/**
	 * Constructs a new BackgroundSmall component.
	 * It initializes the BackgroundSmall component with the loaded image.
	 */
	public BackgroundSmall() {
		super(image);
	}
}
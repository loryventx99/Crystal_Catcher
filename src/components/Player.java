package components;

import util.GetPath;
import util.Util;

import javax.swing.ImageIcon;

public class Player extends Component {
	private static ImageIcon[] images = Util.initializeImageIconArray(GetPath.PLAYER, 6);

	public Player() {
		super(images[0]);
	}

	public void jump() {
	}

	public void move() {
	}
}
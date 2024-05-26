package components;

import util.GetPath;
import util.Util;

import javax.swing.*;

public class Crystal extends JLabel {
	private static ImageIcon image = Util.getImageWithoutBackground(GetPath.CRYSTAL);

	public Crystal() {
		this.setSize(image.getIconWidth(), image.getIconHeight());
		this.setIcon(image);
	}
}
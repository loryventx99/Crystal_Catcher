package util;

import javax.swing.ImageIcon;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Util {
	public static ImageIcon getImageWithoutBackground(String path) {
		ImageIcon icon = new ImageIcon(path);
		BufferedImage bufferedImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = bufferedImage.createGraphics();
		g2d.setComposite(AlphaComposite.Src);
		g2d.drawImage(icon.getImage(), 0, 0, null);
		g2d.dispose();

		return new ImageIcon(bufferedImage);
	}
}
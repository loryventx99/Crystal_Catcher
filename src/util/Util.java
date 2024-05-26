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

	public static ImageIcon[] initializeImageIconArray(String target, int num) {
		ImageIcon[] iconArray = new ImageIcon[num];
		String extension = target.split("\\.")[1];
		String fileName = target.split("\\.")[0];
		fileName = fileName.substring(0, fileName.length() - 1);

		for (int i = 0; i < num; i++) iconArray[i] = getImageWithoutBackground(fileName + i + "." + extension);

		return iconArray;
	}
}
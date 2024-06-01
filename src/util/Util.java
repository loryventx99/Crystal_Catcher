package util;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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

	public static ImageIcon getImageWithoutBackgroundAndScale(String path, int width, int height) {
		Image image = getImageWithoutBackground(path).getImage();
		image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(image);
	}


	public static ImageIcon[] initializeImageIconArrayAndScale(ImageIcon[] imageIcons, int width, int height) {
		BufferedImage image;

		try {
			image = ImageIO.read(new File(GetPath.PLAYER1_6));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		for (int i = 0; i < imageIcons.length; i++) {
			BufferedImage tempImage = image.getSubimage(i * 587, 0, 587, 460);
			ImageIcon icon = new ImageIcon(tempImage);
			BufferedImage bufferedImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);

			Graphics2D g2d = bufferedImage.createGraphics();
			g2d.setComposite(AlphaComposite.Src);
			g2d.drawImage(icon.getImage(), 0, 0, null);
			g2d.dispose();

			imageIcons[i] = new ImageIcon(bufferedImage.getScaledInstance(width, height, Image.SCALE_SMOOTH));
		}

		return imageIcons;
	}
}
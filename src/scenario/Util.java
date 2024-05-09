package scenario;

import javax.swing.ImageIcon;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * Classe per le utility.
 *
 * @author Lorenzo Venturino
 * @author Gabriele Andreani
 * @version 1.0
 */
public class Util {
	/**
	 * Prende un oggetto Image in ingresso e ne restituisce un istanza senza sfondo e scalata.
	 *
	 * @param image L'immagine da modificare
	 */
	public static Image removeBackGroundAndScale(Image image, int width, int height) {
		ImageIcon tempIcon = new ImageIcon(image);
		BufferedImage bufferedImage = new BufferedImage(tempIcon.getIconWidth(), tempIcon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = bufferedImage.createGraphics();
		g2d.setComposite(AlphaComposite.Src);
		g2d.drawImage(image, 0, 0, null);
		g2d.dispose();

		return bufferedImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	}
}
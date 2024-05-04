package scenario;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * Classe per la creazione di una moneta che rotea su se stessa. La moneta viene mostrata in una JLabel.
 * L'animazione viene generata da un thread iterando tra immagini della moneta in varie posizioni dentro un array.
 *
 * @author Lorenzo Venturino
 * @version 1.0
 */
public class Moneta extends JLabel implements Runnable {
	/**
	 * Array di immagini della moneta in varie angolazioni.
	 */
	private static ImageIcon[] icons;
	/**
	 * Larghezza della moneta.
	 */
	private static final int width = 100;
	/**
	 * Altezza della moneta.
	 */
	private static final int height = 100;

	/**
	 * Istanzia una JLabel contenente una moneta.
	 */
	public Moneta() {
		super();
		setPreferredSize(new Dimension(width, height));

		icons = new ImageIcon[4];

		//caricamento immagini, ridimensionamento e rimozione sfondo
		for (int i = 0; i < icons.length; i++) {
			Image image = new ImageIcon("src/scenario/moneta-pos-" + (i + 1) + ".png").getImage();
			icons[i] = new ImageIcon(removeBackGroundAndScale(image));
		}

		setIcon(icons[0]);
	}

	/**
	 * Creazione dell'animazione iterando tra le immagini a intervalli di tempi predefiniti.
	 */
	@Override
	public void run() {
		int j = 1;

		for (int i = 1; i < icons.length; i += j) {
			try {
				Thread.sleep(200);

				setIcon(icons[i]);

				if (i == 3 || i == 0)
					j *= -1;
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * Prende un oggetto Image in input e ne restituisce un istanza senza sfondo e scalata.
	 *
	 * @param image L'immagine da modificare
	 */
	private static Image removeBackGroundAndScale(Image image) {
		ImageIcon tempIcon = new ImageIcon(image);
		BufferedImage bufferedImage = new BufferedImage(tempIcon.getIconWidth(), tempIcon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = (Graphics2D) bufferedImage.createGraphics();
		g2d.setComposite(AlphaComposite.Src);
		g2d.drawImage(image, 0, 0, null);
		g2d.dispose();

		return bufferedImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	}
}
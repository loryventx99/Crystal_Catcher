package scenario;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Image;

/**
 * Classe per la creazione di una moneta che rotea su se stessa. La moneta viene mostrata in una JLabel.
 * L'animazione viene generata da un thread iterando tra immagini della moneta in varie posizioni dentro un array.
 *
 * @author Lorenzo Venturino
 * @version 1.1
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
			Image image = new ImageIcon("src/images/moneta-pos-" + (i + 1) + ".png").getImage();
			icons[i] = new ImageIcon(Util.removeBackGroundAndScale(image, width, height));
		}

		setIcon(icons[0]);
	}

	/**
	 * Creazione dell'animazione iterando tra le immagini a intervalli di tempi predefiniti.
	 */
	@Override
	public void run() {
		int j = 1;
		int i = 1;

		while (true) {
			try {
				Thread.sleep(100);

				setIcon(icons[i]);

				if (i == 3 || i == 0)
					j *= -1;

				i += j;
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
package game;

import components.BackgroundSmall;
import components.MoneyCounter;
import util.GetPath;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class StartMenu extends JPanel {

	public Image createImageWithTransparency(float alpha) {

		ImageIcon icon = new ImageIcon(GetPath.BACKGROUND_SMALL);
		Image image = icon.getImage();

		// Crea una nuova immagine con la stessa dimensione dell'immagine originale
		BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);

		// Ottieni l'oggetto Graphics2D per disegnare sull'immagine
		Graphics2D g2d = bufferedImage.createGraphics();

		// Disegna l'immagine originale
		g2d.drawImage(image, 0, 0, null);

		// Imposta l'alpha composite sulla grafica in base al parametro alpha
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

		// Disegna un rettangolo di copertura sull'immagine originale
		g2d.setColor(new Color(0, 0, 0, 0));
		g2d.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());

		// Libera le risorse
		g2d.dispose();

		return bufferedImage;
	}

	public Image createImageWithTransparency2(float alpha) {
		ImageIcon icon = new ImageIcon(GetPath.BACKGROUND_SMALL);
		Image image = icon.getImage();

		// Create a new BufferedImage with the same dimensions as the original image
		BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);

		// Get the Graphics2D object to draw on the image
		Graphics2D g2d = bufferedImage.createGraphics();

		// Draw the original image
		g2d.drawImage(image, 0, 0, null);

		// Set the alpha composite based on the alpha parameter
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

		// Draw a black rectangle on top of the original image
		g2d.setColor(new Color(0, 0, 0));
		g2d.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());

		// Release the resources
		g2d.dispose();

		return bufferedImage;
	}

}
package scenario;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Dimension;

public class Background extends JLabel {
	private final int width = 2400;
	private final int height = 600;

	public Background() {
		super();

		ImageIcon sfondo = new ImageIcon("src/images/moneta-pos-1.png");
		//dovrebbe essere 800x600
		sfondo = new ImageIcon(Util.removeBackGroundAndScale(sfondo.getImage(), width, height));

		setPreferredSize(new Dimension(width, height));
		setIcon(sfondo);
	}
}
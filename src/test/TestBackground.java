package test;

import scenario.Background;
import scenario.Moneta;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class TestBackground extends JFrame {
	public TestBackground() {
		super("Tester");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, this.getWidth(), this.getHeight());

		Background background = new Background();
		background.setBounds(0, 0, 2400, 600);
		background.setOpaque(true);

		Moneta m = new Moneta();
		m.setBounds(100, 300, 100, 100);
		m.setOpaque(true);

		layeredPane.add(background, 1);
		layeredPane.add(m, 2);

		add(layeredPane);

		new Thread(m).start();

		setVisible(true);
	}

	public static void main(String[] args) {
		new TestBackground();
	}
}
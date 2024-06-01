package tester;

import game.StartMenu;

import javax.swing.*;

public class Trasparenza extends JFrame {
	public static void main(String[] args) {
		new Trasparenza();
	}

	public Trasparenza() {
		this.setTitle("Trasparenza");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);

		StartMenu sm = new StartMenu();

		this.add(sm);
		sm.createImageWithTransparency2(0.1f);

		this.setVisible(true);
	}
}
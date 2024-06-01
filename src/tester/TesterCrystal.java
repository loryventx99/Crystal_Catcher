package tester;

import components.Crystal;

import javax.swing.*;
import java.awt.*;

public class TesterCrystal extends JFrame {
	public static void main(String[] args) {
		new TesterCrystal();
	}

	public TesterCrystal() {
		this.setTitle("TesterCrystal");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.BLACK);

		add(new Crystal(400, 300));

		this.setVisible(true);
	}
}

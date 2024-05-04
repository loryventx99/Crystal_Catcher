package test;

import scenario.Moneta;

import javax.swing.*;

public class TesterMoneta extends JFrame {
	public TesterMoneta() {
		super("Tester");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);

		Moneta m = new Moneta();
		add(m);

		setVisible(true);
	}

	public static void main(String[] args) {
		new TesterMoneta();
	}
}
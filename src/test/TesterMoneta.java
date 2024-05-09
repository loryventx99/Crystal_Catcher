package test;

import scenario.Moneta;

import javax.swing.JFrame;
import java.awt.Color;

public class TesterMoneta extends JFrame {

	public TesterMoneta() {
		super("Tester");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 600);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.BLACK);

		Moneta m = new Moneta();
		add(m);
		new Thread(m).start();

		setVisible(true);
	}

	public static void main(String[] args) {
		new TesterMoneta();
	}
}
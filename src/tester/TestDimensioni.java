package tester;

import util.GetPath;
import util.Util;

import javax.swing.*;
import java.awt.*;

public class TestDimensioni extends JFrame {
	public static void main(String[] args) {
		new TestDimensioni();
	}

	public TestDimensioni() {
		this.setTitle("Test Dimensioni");
		this.setSize(800, 550);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//getContentPane().setBackground(Color.GRAY);

		JPanel panel = new JPanel();
		panel.setSize(100, 100);
		panel.setBackground(Color.BLACK);

		JPanel panel2 = new JPanel();
		panel2.setSize(100, 150);
		panel2.setBackground(Color.BLUE);
		panel2.setLocation(100, 0);

		JLabel label = new JLabel("1234567890");
		label.setIcon(Util.getImageWithoutBackground(GetPath.HEART));
		label.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		panel2.add(label);

		///this.add(panel);
		this.add(panel2);

		this.setVisible(true);
	}
}
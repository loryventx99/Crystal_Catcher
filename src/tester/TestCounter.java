package tester;

import components.MoneyCounter;

import javax.swing.*;
import java.awt.*;

public class TestCounter extends JFrame {
	public static void main(String[] args) {
		new TestCounter();
	}

	public TestCounter() {
		this.setTitle("Test Counter");
		this.setSize(800, 550);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.BLACK);

		MoneyCounter counter = new MoneyCounter(800 - 150, 0, 150, 40, 0);
		counter.setLocation(650, 0);
		this.add(counter);

		this.setVisible(true);

		while (true) {
			try {
				Thread.sleep(100);
				counter.increment();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
package tester;

import components.Hearts;

import javax.swing.*;
import java.awt.*;

public class TestCuori extends JFrame {
	public static void main(String[] args) {
		new TestCuori();
	}

	public TestCuori() {
		this.setTitle("Test Cuori");
		this.setSize(800, 550);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.BLACK);

		Hearts h = new Hearts(120, 40, 3);
		this.add(h);

		this.setVisible(true);

		for (int i = 0; i < 3; i++) {
			try {
				Thread.sleep(2000);
				h.decrementHearts();
				System.out.println(h.getHeartsCount());
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}

		System.out.println(h.getHeartsCount());
	}
}
package tester;

import components.Player;

import javax.swing.*;
import java.awt.*;

public class PlayerTester extends JFrame {
	public static void main(String[] args) {
		new PlayerTester();
	}

	public PlayerTester() {
		this.setTitle("PlayerTester");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.BLACK);

		//Player player = new Player(150, 100);

		//this.add(player);

		this.setVisible(true);
	}
}
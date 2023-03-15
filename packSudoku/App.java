package Sudoku.packSudoku;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class App extends JFrame{
	private JLabel gameTitle;
	private JButton buttonPlay;
	private JButton buttonScoreboard;
	private JButton buttonCredit;

	public App() {
		this.setTitle("Sudoku");
		this.setBackground(new Color(217, 217, 217));
		this.setSize(600, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		addFont();
		initComponents();
		this.setVisible(true);
	}

	private void addFont() {
		String fontPath = "C:/Users/modda/OneDrive/Documents/KMITL/ปี 1/เทอม 2/OOP/Sudoku/packSudoku/pixellet.ttf";

		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)));
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}
	}

	private void initComponents() {
		gameTitle = new JLabel("Sudoku Game");
		buttonPlay = new JButton("Play");
		buttonScoreboard = new JButton("Scoreboard");
		buttonCredit = new JButton("Credit");

		Font titleFont = new Font("pixellet", Font.PLAIN, 40);
		gameTitle.setFont(titleFont);
		gameTitle.setForeground(Color.black);

		Font bottonFont = new Font("pixellet", Font.PLAIN, 25);
		buttonPlay.setFont(bottonFont); buttonScoreboard.setFont(bottonFont); buttonCredit.setFont(bottonFont);

		buttonScoreboard.setPreferredSize(new Dimension(300, 40));
		buttonPlay.setPreferredSize(new Dimension(300, 40));
		buttonCredit.setPreferredSize(new Dimension(300, 40));

		// จัดการ Layout
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		// วางตำแหน่ง
		c.insets = new Insets(2, 2, 10, 2);
		c.ipady = 30;
		c.gridx = 0;
		c.gridy = 1; this.add(gameTitle, c);
		c.gridy = 2; this.add(buttonPlay, c);
		c.gridy = 3; this.add(buttonScoreboard, c);
		c.gridy = 4; this.add(buttonCredit, c);

		// ลงสี
		Color bottonBgColor = new Color(98, 98, 98);
		Color bottonFgColor = Color.WHITE;
		buttonPlay.setBackground(bottonBgColor); buttonPlay.setForeground(bottonFgColor);
		buttonScoreboard.setBackground(bottonBgColor); buttonScoreboard.setForeground(bottonFgColor);
		buttonCredit.setBackground(bottonBgColor); buttonCredit.setForeground(bottonFgColor);
	}
}

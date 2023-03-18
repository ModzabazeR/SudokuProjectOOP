package Sudoku.packSudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class App extends JFrame implements ActionListener {
	private JLabel gameTitle;
	private JButton buttonPlay;
	private JButton buttonTutorial;
	private JButton buttonCredit;

	public App() {
		this.setTitle("Sudoku");
		this.setBackground(new Color(217, 217, 217));
		this.setSize(600, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		addFont();
		initComponents();
		setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}

	private void addFont() {
		String fontPath = "Sudoku/packSudoku/2005_iannnnnCPU.ttf";

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
		buttonTutorial = new JButton("Tutorial");
		buttonCredit = new JButton("Credit");

		Font titleFont = new Font("2005_iannnnnCPU", Font.PLAIN, 60);
		gameTitle.setFont(titleFont);
		gameTitle.setForeground(Color.black);

		Font bottonFont = new Font("2005_iannnnnCPU", Font.PLAIN, 45);
		buttonPlay.setFont(bottonFont);
		buttonTutorial.setFont(bottonFont);
		buttonCredit.setFont(bottonFont);

		buttonTutorial.setPreferredSize(new Dimension(300, 40));
		buttonPlay.setPreferredSize(new Dimension(300, 40));
		buttonCredit.setPreferredSize(new Dimension(300, 40));

		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.insets = new Insets(2, 2, 10, 2);
		c.ipady = 30;
		c.gridx = 0;
		c.gridy = 1;
		this.add(gameTitle, c);
		c.gridy = 2;
		this.add(buttonPlay, c);
		c.gridy = 3;
		this.add(buttonTutorial, c);
		c.gridy = 4;
		this.add(buttonCredit, c);

		Color bottonBgColor = new Color(98, 98, 98);
		Color bottonFgColor = Color.WHITE;
		buttonPlay.setBackground(bottonBgColor);
		buttonPlay.setForeground(bottonFgColor);
		buttonTutorial.setBackground(bottonBgColor);
		buttonTutorial.setForeground(bottonFgColor);
		buttonCredit.setBackground(bottonBgColor);
		buttonCredit.setForeground(bottonFgColor);

		buttonPlay.setOpaque(true);
		buttonPlay.setBorderPainted(false);

		buttonTutorial.setOpaque(true);
		buttonTutorial.setBorderPainted(false);

		buttonCredit.setOpaque(true);
		buttonCredit.setBorderPainted(false);

		buttonPlay.addActionListener(this);
		buttonTutorial.addActionListener(this);
		buttonCredit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		if (source == buttonPlay) {
			new Game(getLocation());
		} else if (source == buttonTutorial) {
			JOptionPane.showMessageDialog(this, "Tutorial");
		} else if (source == buttonCredit) {
			JOptionPane.showMessageDialog(this, "Credit");
		}
	}

}

package Sudoku.packSudoku;

import javax.swing.*;

import Sudoku.packSudoku.components.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Game extends JFrame implements PuzzleTemplate {
	private Random rand = new Random();
	private int[][] puzzle = PUZZLES[rand.nextInt(PUZZLES.length)];

	public class JPanelGrid extends JPanel {
		private JButton[][] buttons = new JButton[3][3];

		public JPanelGrid() {
			setLayout(new GridLayout(3, 3, 3, 3));
			buildBoard();
		}

		private void buildBoard() {
			for (int i = 0; i < buttons.length; i++) {
				for (int j = 0; j < buttons.length; j++) {
					String text = (puzzle[i][j] == 0) ? "" : "" + puzzle[i][j];
					buttons[i][j] = new JButton(text);

					buttons[i][j].setBackground(new Color(98, 98, 98));
					buttons[i][j].setForeground(Color.WHITE);
					buttons[i][j].setFont(new Font("pixellet", Font.PLAIN, 25));
					buttons[i][j].setPreferredSize(new Dimension(80, 80));
					if (puzzle[i][j] != 0) buttons[i][j].setEnabled(false);

					BoardListener b = new BoardListener();
					buttons[i][j].addActionListener(b);
					add(buttons[i][j]);
				}
			}
		}

		private class BoardListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton)e.getSource();
				int currentNum = (source.getText().equals("")) ? 0 : Integer.parseInt(source.getText());
				currentNum++;
				if (currentNum == 4) currentNum = 1;
				source.setText("" + currentNum);
			}
		}
	}

	public Game(int width, int height, Point position) {
		setTitle("Game");
		setBackground(new Color(217, 217, 217));
		setSize(width, height);
		setLocation(position);
		setLayout(new FlowLayout());
		initComponents();
		setVisible(true);
	}

	private void initComponents() {
		JPanelGrid mainPanel = new JPanelGrid();
		mainPanel.setPreferredSize(new Dimension(400,400));
		getContentPane().add(mainPanel);
	}
}

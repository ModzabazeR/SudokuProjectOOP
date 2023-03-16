package Sudoku.packSudoku;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Sudoku.packSudoku.components.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Game extends JFrame implements PuzzleTemplate {
	private Random rand = new Random();
	private int[][] puzzle = PUZZLES[rand.nextInt(PUZZLES.length)];
	GameBoard gameBoard;
	AllButtonPanel allButtons;

	class GameBoard extends JPanel {
		private JButton[][] buttons = new JButton[3][3];

		public GameBoard() {
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

					buttons[i][j].setOpaque(true);
					buttons[i][j].setBorderPainted(false);

					if (puzzle[i][j] != 0) buttons[i][j].setEnabled(false);

					BoardListener b = new BoardListener();
					buttons[i][j].addActionListener(b);
					add(buttons[i][j]);
				}
			}
		}

		private boolean resolve() {
			for (int r = 0; r < 3; r++) {
				JButton[] row = buttons[r];
				for (int i = 0; i < 3; i++) {
					for (int j = i + 1; j < 3; j++) {
						String num1 = row[i].getText();
						String num2 = row[j].getText();
						if (num1.equals(num2)) return false;
					}
				}
			}
			return true;
		}

		private void changeBoardColorCorrect() {
			 for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					JButton curButton = buttons[i][j];
					curButton.setBackground(new Color(82, 204, 146));
					curButton.setForeground(Color.WHITE);
					curButton.setEnabled(false);
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

	class AllButtonPanel extends JPanel implements ActionListener{
		private JButton buttonReset;
		private JButton buttonNextGame;
		private JButton buttonMenu;
		private JButton buttonResolve; 
		private ImageIcon iconReset;
		private ImageIcon iconNextGame;
		private ImageIcon iconHome;
		private ImageIcon iconResolve;
		private Game root;

		public AllButtonPanel(Game root) {
			this.root = root;
			setLayout(new GridLayout(1, 4));
			initComponents();
		}

		private void initComponents() {
			try {
				iconReset = new ImageIcon("Sudoku/packSudoku/img/undo.png");
				iconNextGame = new ImageIcon("Sudoku/packSudoku/img/next.png");
				iconHome = new ImageIcon("Sudoku/packSudoku/img/home.png");
				iconResolve = new ImageIcon("Sudoku/packSudoku/img/view.png");
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			buttonReset = new JButton(iconReset);
			buttonNextGame = new JButton(iconNextGame);
			buttonMenu = new JButton(iconHome);
			buttonResolve = new JButton(iconResolve);
			
			Font bottonFont = new Font("pixellet", Font.PLAIN, 25);
			buttonReset.setFont(bottonFont);
			buttonNextGame.setFont(bottonFont);
			buttonMenu.setFont(bottonFont);
			buttonResolve.setFont(bottonFont);
	
			Color bottonBgColor = new Color(217, 217, 217);
			Color bottonFgColor = Color.WHITE;
			buttonReset.setBackground(bottonBgColor);
			buttonReset.setForeground(bottonFgColor);
			buttonNextGame.setBackground(bottonBgColor);
			buttonNextGame.setForeground(bottonFgColor);
			buttonMenu.setBackground(bottonBgColor);
			buttonMenu.setForeground(bottonFgColor);
			buttonResolve.setBackground(bottonBgColor);
			buttonResolve.setForeground(bottonFgColor);
	
			buttonReset.setPreferredSize(new Dimension(50, 50));
			buttonNextGame.setPreferredSize(new Dimension(50, 50));
			buttonMenu.setPreferredSize(new Dimension(50, 50));
			buttonResolve.setPreferredSize(new Dimension(150, 50));
	
			this.add(buttonMenu);
			this.add(buttonNextGame);
			this.add(buttonReset);
			this.add(buttonResolve);
	
			buttonReset.setOpaque(false);
			buttonReset.setBorderPainted(false);
			buttonReset.setContentAreaFilled(false);
	
			buttonNextGame.setOpaque(false);
			buttonNextGame.setBorderPainted(false);
			buttonNextGame.setContentAreaFilled(false);
	
			buttonMenu.setOpaque(false);
			buttonMenu.setBorderPainted(false);
			buttonMenu.setContentAreaFilled(false);
	
			buttonResolve.setOpaque(false);
			buttonResolve.setBorderPainted(false);
			buttonResolve.setContentAreaFilled(false);
	
			buttonReset.addActionListener(this);
			buttonNextGame.addActionListener(this);
			buttonMenu.addActionListener(this);
			buttonResolve.addActionListener(this);
		}

			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton)e.getSource();
				if (source == buttonReset) {
					gameBoard.removeAll();
					gameBoard.buildBoard();
					gameBoard.revalidate();
				} else if (source == buttonNextGame) {
					int[][] oldPuzzle = puzzle; 
					puzzle = PUZZLES[rand.nextInt(PUZZLES.length)];
					while (puzzle == oldPuzzle){
						puzzle = PUZZLES[rand.nextInt(PUZZLES.length)];
					}
					gameBoard.removeAll();
					gameBoard.buildBoard();
					gameBoard.revalidate();
				} else if (source == buttonMenu) {
					dispose();
				} else if (source == buttonResolve) {
					if (gameBoard.resolve()) {
						gameBoard.changeBoardColorCorrect();
					} else {
						JOptionPane.showMessageDialog(root, "The answer is incorrect!", "Incorrect", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
	}
	public Game(Point position) {
		setTitle("Game");
		setBackground(new Color(217, 217, 217));
		setSize(600, 600);
		setLocation(position);
		setResizable(false);
		setLayout(new FlowLayout());
		initComponents();
		setVisible(true);
	}

	private void initComponents() {
		gameBoard = new GameBoard();
		gameBoard.setPreferredSize(new Dimension(400,400));
		gameBoard.setBorder(new EmptyBorder(50, 30, 20, 30));
		allButtons = new AllButtonPanel(this);
		allButtons.setPreferredSize(new Dimension(350, 80));
		getContentPane().add(gameBoard);
		getContentPane().add(allButtons);
	}
}

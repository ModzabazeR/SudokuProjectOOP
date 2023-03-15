package Sudoku.packSudoku.components;

public class Board3x3 {
	private NumberBox[][] member;
	private NumberBox[][] defaultMember;

	public static void main(String[] args) {
		Board3x3 board = new Board3x3();
		System.out.println(board);
	}

	public Board3x3() {
		member = new NumberBox[3][3];
		randomNumbers();
	}

	private void randomNumbers() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				member[i][j] = new NumberBox(0);
			}
		}
	}

	public boolean checkAnswer() {
		return false;
	}

	public void reset() {
		this.member = this.defaultMember.clone();
	}

	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				str += member[i][j].getNumber() + " ";
			}
			str += "\n";
		}
		return str;
	}
}

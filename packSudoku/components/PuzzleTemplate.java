package Sudoku.packSudoku.components;

public interface PuzzleTemplate {
	public static final int[][] PUZZLE_1 = {{1, 0, 0},
										   {2, 0, 3},
										   {0, 2, 1}};
	public static final int[][] PUZZLE_2 = {{2, 0, 3},
											{1, 0, 0},
											{0, 0, 1}};
	public static final int[][] PUZZLE_3 = {{1, 0, 0},
											{0, 2, 0},
											{0, 0, 3}};
	public static final int[][] PUZZLE_4 = {{3, 0, 2},
											{0, 0, 0},
											{0, 0, 1}};
	public static final int[][] PUZZLE_5 = {{0, 0, 3},
											{0, 2, 0},
											{1, 0, 0}};

	public static final int[][][] PUZZLES = {PUZZLE_1, PUZZLE_2, PUZZLE_3, PUZZLE_4, PUZZLE_5};
}

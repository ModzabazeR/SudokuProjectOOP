package Sudoku.packSudoku.components;

public class NumberBox {
	private int number;
	private int squareSize;
	private String backgroundColor;
	private String textColor;
	private boolean editable;

	public NumberBox(int number) {
		this.number = number;
		this.backgroundColor = "gray";
		this.textColor = "black";
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getSquareSize() {
		return squareSize;
	}

	public void setSquareSize(int squareSize) {
		this.squareSize = squareSize;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public String getTextColor() {
		return textColor;
	}

	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public void updateNumber() {
		this.number = (this.number + 1) % 3;
	}

	@Override
	public String toString() {
		return "" + number;
	}
}

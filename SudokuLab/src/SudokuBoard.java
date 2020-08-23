import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import gameBoards.SudokuGUI;

public class SudokuBoard {
	private SudokuGUI gui;
	private int[][] board;

	// constructor-ul
	public SudokuBoard() {
		gui = new SudokuGUI();
		board = new int[9][9];
	}

	// construieste tabla sudoku
	public void loadPuzzle(String s) throws FileNotFoundException {
		Scanner read = new Scanner(new File(s));
		int row = 0;
		while (read.hasNextLine()) {
			String line = read.nextLine();
			if (!line.isEmpty()) {
				int col = 0;
				for (int i = 0; i < line.length(); ++i) {
					char ch = line.charAt(i);
					if (ch == ' ')
						continue;
					if (ch == '.')
						++col;
					else {
						board[row][col] = (ch - '0');
						++col;
					}
				}
				++row;
			}
		}
	}

	// porneste procesul de rezolvare al sudokulului
	public boolean solvePuzzle(int row, int col) {
		int nextRow = row + (col + 1) / 9;
		int nextCol = (col + 1) % 9;
		if (board[row][col] > 0) {
			return (nextRow < 0 || nextRow >= 9 || nextCol < 0 || nextCol >= 9 || solvePuzzle(nextRow, nextCol));
		}
		for (int nr = 1; nr <= 9; nr++)
			if (isValid(nr, row, col)) {
				board[row][col] = nr;
				gui.draw(board);
				if (nextRow < 0 || nextRow >= 9 || nextCol < 0 || nextCol >= 9 || solvePuzzle(nextRow, nextCol))
					return true;
				board[row][col] = 0;
			}
		return false;
	}

	// rezolva sudokul pentru o pozitie data
	public boolean solvePuzzle() {
		gui.pause();
		return solvePuzzle(0, 0);
	}

	// deseneaza tabla
	public void drawPuzzle() {
		gui.draw(board);
	}

	// verifica daca un numar este valid pe o pozitie din sudoku
	public boolean isValid(int number, int row, int col) {
		boolean valid = true;
		for (int r = 0; r < 9 && valid; r++) {
			valid = (number != board[r][col]);
		}
		if (!valid)
			return valid;
		for (int c = 0; c < 9 && valid; c++) {
			valid = (number != board[row][c]);
		}
		if (!valid)
			return valid;
		int groupR = (row / 3) * 3;
		int groupC = (col / 3) * 3;
		for (int r = groupR; r < groupR + 3 && valid; r++)
			for (int c = groupC; c < groupC + 3 && valid; c++)
				valid = (number != board[r][c]);
		return valid;
	}

}

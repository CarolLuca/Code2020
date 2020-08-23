import java.awt.Color;
import java.io.FileNotFoundException;

import gameBoards.SudokuGUI;

public class Sudoku {

	public static void main(String[] args) throws FileNotFoundException {
		SudokuBoard sb = new SudokuBoard();
		sb.loadPuzzle("Sudoku1.txt");
		boolean theEnd = sb.solvePuzzle();
		sb.drawPuzzle();
		System.out.println(theEnd ? "success" : "failure");
	}

}
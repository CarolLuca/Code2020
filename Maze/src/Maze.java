import java.awt.Color;

import graphics.MazeCanvas;
import graphics.MazeCanvas.Side;

public class Maze {
	private MazeCanvas mc;
	private Cell[][] gridOfCells;
	private Cell entryCell;
	private Cell exitCell;

	public Maze(MazeCanvas other) {
		mc = other;
		gridOfCells = new Cell[mc.getRows()][mc.getCols()];
		for (int row = 0; row < mc.getRows(); row++) {
			for (int col = 0; col < mc.getCols(); col++) {
				mc.drawCell(row, col);
			}
		}
	}

	Color darkRed = new Color(224, 0, 0);

	public void genSnake() {
		for (int rand = 0; rand < mc.getRows(); rand++) {
			for (int coloana = 0; coloana < mc.getCols(); coloana++) {
				if (rand == 0) {
					if (coloana % 2 == 0) {
						mc.eraseWall(rand, coloana, Side.Left);
						mc.eraseWall(rand, coloana, Side.Bottom);
						mc.drawPath(rand, coloana, Side.Left, Color.RED);
						mc.drawPath(rand, coloana, Side.Bottom, Color.RED);
						mc.drawCenter(rand, coloana, darkRed);
					} else {
						mc.eraseWall(rand, coloana, Side.Right);
						mc.eraseWall(rand, coloana, Side.Bottom);
						mc.drawPath(rand, coloana, Side.Right, Color.RED);
						mc.drawPath(rand, coloana, Side.Bottom, Color.RED);
						mc.drawCenter(rand, coloana, darkRed);
					}
				} else {
					if (rand == mc.getRows() - 1) {
						if (coloana % 2 == 0) {
							mc.eraseWall(rand, coloana, Side.Right);
							mc.eraseWall(rand, coloana, Side.Top);
							mc.drawPath(rand, coloana, Side.Right, Color.RED);
							mc.drawPath(rand, coloana, Side.Top, Color.RED);
							mc.drawCenter(rand, coloana, darkRed);
						} else {
							mc.eraseWall(rand, coloana, Side.Left);
							mc.eraseWall(rand, coloana, Side.Top);
							mc.drawPath(rand, coloana, Side.Left, Color.RED);
							mc.drawPath(rand, coloana, Side.Top, Color.RED);
							mc.drawCenter(rand, coloana, darkRed);
						}
					} else {
						mc.eraseWall(rand, coloana, Side.Bottom);
						mc.eraseWall(rand, coloana, Side.Top);
						mc.drawPath(rand, coloana, Side.Bottom, Color.RED);
						mc.drawPath(rand, coloana, Side.Top, Color.RED);
						mc.drawCenter(rand, coloana, Color.RED);
					}
				}
			}
		}
	}

	private static final Color fundal=new Color(0,0,0);
	public void initialize() {
		int count = ((mc.getRows() - 2) * (mc.getCols() - 2)) / 20;
		int nPerim = 2 * mc.getRows() + 2 * mc.getCols() - 4, edgeCount = 0;
		int iEntry = (int) (Math.random() * nPerim);
		// int iExit= (iEntry+(int)( (1-Math.random())* nPerim ))%nPerim;
		int iExit = nPerim - iEntry - 1; // --- diagonal opus ---
		for (int rand = 0; rand < mc.getRows(); rand++) {
			for (int coloana = 0; coloana < mc.getCols(); coloana++) {
				if (rand == 0 || coloana == 0 || rand == mc.getRows() - 1 || coloana == mc.getCols() - 1) {
					if (edgeCount == iEntry) {
						entryCell = new EntryCell(mc, rand, coloana);
						gridOfCells[rand][coloana] = entryCell;
					} else if (edgeCount == iExit) {
						exitCell = new ExitCell(mc, rand, coloana);
						gridOfCells[rand][coloana] = exitCell;
					} else {
						gridOfCells[rand][coloana] = new EdgeCell(mc, rand, coloana);
					}
					edgeCount++;
				} else if (Math.random() <= 0.05 && count > 0) {
					gridOfCells[rand][coloana] = new BlockCell(mc, rand, coloana);
					count--;
				} else {
					gridOfCells[rand][coloana] = new Cell(mc, rand, coloana);
				}
			}
		}
	}

	public Cell getCell(int row, int col) {
		return gridOfCells[row][col];
	}

	public Cell getEntryCell() {
		return entryCell;
	}

	public Cell getExitCell() {
		return exitCell;
	}

	public Cell getNeighbor(Cell cell, Side side) {
		if (side == Side.Top && cell.getRow() > 0)
			return gridOfCells[cell.getRow() - 1][cell.getCol()];
		if (side == Side.Bottom && cell.getRow() + 1 < mc.getRows())
			return gridOfCells[cell.getRow() + 1][cell.getCol()];
		if (side == Side.Left && cell.getCol() > 0)
			return gridOfCells[cell.getRow()][cell.getCol() - 1];
		if (side == Side.Right && cell.getCol() + 1 < mc.getCols())
			return gridOfCells[cell.getRow()][cell.getCol() + 1];
		return (Cell) null;

	}
}
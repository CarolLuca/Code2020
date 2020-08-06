import java.util.ArrayList;
import java.util.Collections;

import graphics.MazeCanvas;
import graphics.MazeCanvas.Side;

public class Cell {
	protected int row;
	protected int column;
	protected MazeCanvas mc;
	private boolean visited = false;
	private ArrayList<Side> listOfWalls;

	public boolean getVisited() {
		return this.visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Cell(MazeCanvas _mc, int _row, int _column) {
		mc = _mc;
		row = _row;
		column = _column;
		listOfWalls = new ArrayList<Side>();
		Collections.addAll(listOfWalls, new Side[] { Side.Bottom, Side.Top, Side.Left, Side.Right });
		mc.drawCell(row, column);
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return column;
	}

	public ArrayList<Side> getWalls() {
		return new ArrayList<Side>(listOfWalls);
	}

	public void removeWall(Side side) {
		mc.eraseWall(row, column, side);
		listOfWalls.remove((Side) side);
	}

	public ArrayList<Side> getPaths() {
		ArrayList<Side> listOfPaths = new ArrayList<Side>();
		Collections.addAll(listOfPaths, new Side[] { Side.Bottom, Side.Top, Side.Left, Side.Right });
		for (Side side : listOfWalls)
			listOfPaths.remove((Side) side);
		return listOfPaths;
	}
}

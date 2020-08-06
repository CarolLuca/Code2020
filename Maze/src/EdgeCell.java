import java.awt.Color;
import java.util.ArrayList;

import graphics.MazeCanvas;
import graphics.MazeCanvas.Side;

public class EdgeCell extends ShadedCell {

	private static final Color edgeColor = new Color(101, 97, 212);
	private ArrayList<Side> listOfEdges;

	public EdgeCell(MazeCanvas _mc, int _row, int _column) {
		super(_mc, _row, _column, edgeColor);
		listOfEdges = new ArrayList<Side>();
		if (_row == 0)
			listOfEdges.add(Side.Top);
		else if (_row == mc.getRows() - 1)
			listOfEdges.add(Side.Bottom);
		if (_column == 0)
			listOfEdges.add(Side.Left);
		else if (_column == mc.getCols() - 1)
			listOfEdges.add(Side.Right);
	}

	public ArrayList<Side> getWalls() {
		ArrayList<Side> walls = super.getWalls();
		for (Side edge : listOfEdges)
			walls.remove((Side) edge);
		return walls;
	} 
}

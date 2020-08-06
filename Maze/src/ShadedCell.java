import java.util.ArrayList;
import java.util.Collections;

import graphics.MazeCanvas;
import graphics.MazeCanvas.Side;

import java.awt.Color;

public class ShadedCell extends Cell {

	private Color culoare;

	public ShadedCell(MazeCanvas _mc, int _row, int _column, Color _culoare) {
		super(_mc, _row, _column);
		culoare = _culoare;
		mc.drawCell(row, column, culoare);
	} 
}

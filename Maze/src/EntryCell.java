import java.awt.Color;

import graphics.MazeCanvas;
import graphics.MazeCanvas.Side;

public class EntryCell extends EdgeCell {
	private static final Color entryShadeColor = new Color(255, 255, 0);

	public EntryCell(MazeCanvas mc, int row, int col) {
		super(mc, row, col);
		mc.drawShade(row, col, entryShadeColor);
	}
}

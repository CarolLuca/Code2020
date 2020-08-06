import java.awt.Color;

import graphics.MazeCanvas;
import graphics.MazeCanvas.Side;

public class ExitCell extends EdgeCell {
	private static final Color exitShadeColor = new Color(255, 72, 0);

	public ExitCell(MazeCanvas mc, int row, int col) {
		super(mc, row, col);
		mc.drawShade(row, col, exitShadeColor);
	} 
}

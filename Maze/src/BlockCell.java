import java.awt.Color;
import java.util.ArrayList;

import graphics.MazeCanvas;
import graphics.MazeCanvas.Side;

public class BlockCell extends ShadedCell {
	private static final Color blockShadeColor = Color.LIGHT_GRAY;

	@Override
	public boolean getVisited() {
		return true;
	}

	public BlockCell(MazeCanvas mc, int row, int col) {
		super(mc, row, col, blockShadeColor);
	}
}

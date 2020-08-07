import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

import graphics.MazeCanvas;
import graphics.MazeCanvas.Side;

public class Generator extends Explorer{

	private static final Color generatePathColor = new Color(85, 138, 70);
	private static final Color generateHeadColor = new Color(255, 255, 0);

	public Generator(MazeCanvas _mc, Maze _mz) {
		super(_mc,_mz, new Color(85, 138, 70), (Color) null);
	}

	protected boolean onEnterCell(Cell cell, Side side) {
		super.onEnterCell(cell,side);
		cell.removeWall(side);
		mc.step(10);
		return false;
	}

	protected ArrayList<Side> onGetNextSteps(Cell cell) {
		return shuffle(cell.getWalls());
	}

	protected void onStepForward(Cell cell, Side side) {
		mc.drawCenter(cell.getRow(), cell.getCol(), generateHeadColor);
		super.onStepForward(cell,side);
		cell.removeWall(side);
	}


}

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

import graphics.MazeCanvas;
import graphics.MazeCanvas.Side;

public class Solver extends Explorer{

	private static final Color generateHeadColor = new Color(159,224,146);

	public Solver(MazeCanvas _mc, Maze _mz) {
		super(_mc,_mz,new Color(66,161,47),new Color(255, 156, 156));
	}
	
	protected boolean onEnterCell(Cell cell, Side side) {
		super.onEnterCell(cell,side);
		mc.drawCenter(cell.getRow(), cell.getCol(), generateHeadColor);
		if(cell==mz.getExitCell())
			return true;
		return false;
	}
	
	protected ArrayList<Side> onGetNextSteps(Cell cell) {
		return shuffle(cell.getPaths());
	}

}

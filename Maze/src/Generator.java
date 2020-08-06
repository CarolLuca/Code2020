import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

import graphics.MazeCanvas;
import graphics.MazeCanvas.Side;

public class Generator {
	private MazeCanvas mc;
	private Maze mz;
	private static final Color generatePathColor = new Color(252, 3, 186);
	private static final Color generateHeadColor = new Color(0, 0, 0);

	public Generator(MazeCanvas _mc, Maze _mz) {
		mc = _mc;
		mz = _mz;
	}

	public ArrayList<Side> shuffle(ArrayList<Side> sides) {
		Collections.shuffle(sides);
		return sides;
	}

	public Side getOpposite(Side side) {
		Side afis = side;
		if (side == Side.Top)
			afis = Side.Bottom;
		else if (side == Side.Bottom)
			afis = Side.Top;
		else if (side == Side.Left)
			afis = Side.Right;
		else if (side == Side.Right)
			afis = Side.Left;
		return afis;
	}

	public boolean run(Cell cell, Side side) {
		cell.setVisited(true);
		mc.drawPath(cell.getRow(), cell.getCol(), side, generatePathColor);
		mc.drawCenter(cell.getRow(), cell.getCol(), generateHeadColor);
		cell.removeWall(side);
		mc.step(10);
		ArrayList<Side> walls = shuffle(cell.getWalls());
		for (Side latura : walls) {
			Cell vecin = mz.getNeighbor(cell, latura);
			if (!vecin.getVisited()) { // ---------------------------------------------
				mc.drawPath(cell.getRow(), cell.getCol(), latura, generatePathColor);
				mc.drawCenter(cell.getRow(), cell.getCol(), generatePathColor);
				cell.removeWall(latura);
				run(vecin, getOpposite(latura));
				mc.erasePath(cell.getRow(), cell.getCol(), latura);
			}
		}
		mc.step(10);
		mc.eraseCenter(cell.getRow(), cell.getCol());
		mc.erasePath(cell.getRow(), cell.getCol(), side);
		return false;
	}

	public boolean run() {
		return run(mz.getEntryCell(), Side.Center);
	}
}

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

import graphics.MazeCanvas;
import graphics.MazeCanvas.Side;

public class Explorer {

	protected Maze mz;
	protected MazeCanvas mc;
	protected Color fwdPathColor;
	protected Color bktPathColor;

	protected ArrayList<Side> shuffle(ArrayList<Side> sides) {
		Collections.shuffle(sides);
		return sides;
	}

	protected Side getOpposite(Side side) {
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

	public Explorer(MazeCanvas _mc, Maze _mz, Color fwdcolor, Color bktcolor) {
		mc = _mc;
		mz = _mz;
		fwdPathColor = fwdcolor;
		bktPathColor = bktcolor;

	}

	public boolean run(Cell cell, Side side) {
		cell.setVisited(true);
		boolean done = onEnterCell(cell, side);
		if (done)
			return true;
		ArrayList<Side> listOfPaths = onGetNextSteps(cell);
		for (Side latura : listOfPaths)
			if (!done) {
				Cell vecin = mz.getNeighbor(cell, latura);
				if (!vecin.getVisited()) {
					onStepForward(cell, latura);
					done = run(vecin, getOpposite(latura));
					if (done)
						return true;
					onStepBack(done, cell, latura);
				}
			}
		onExitCell(done, cell, side);
		return done;
	}

	public boolean run() {
		for (int i = 0; i < mc.getRows(); i++)
			for (int j = 0; j < mc.getCols(); j++) {
				mz.getCell(i, j).setVisited(false);
			}
		return run(mz.getEntryCell(), Side.Center);
	}

	protected boolean onEnterCell(Cell cell, Side side) {
		if (fwdPathColor != null) {
			mc.drawPath(cell.getRow(), cell.getCol(), side, fwdPathColor);
			mc.drawCenter(cell.getRow(), cell.getCol(), fwdPathColor);
		}
		return false;
	}

	protected ArrayList<Side> onGetNextSteps(Cell cell) {
		return new ArrayList<Side>();
	}

	protected void onStepForward(Cell cell, Side side) {
		mc.drawPath(cell.getRow(), cell.getCol(), side, fwdPathColor);
		mc.step(10);
	}

	protected void onStepBack(boolean done, Cell cell, Side side) {
		if (!done) {
			if (bktPathColor != null) {
				mc.drawPath(cell.getRow(), cell.getCol(), side, bktPathColor);
			} else {
				mc.erasePath(cell.getRow(), cell.getCol(), side);
			}
		}
	}

	protected void onExitCell(boolean done, Cell cell, Side side) {
		if (!done) {
			if (bktPathColor != null) {
				mc.drawPath(cell.getRow(), cell.getCol(), side, bktPathColor);
				mc.drawCenter(cell.getRow(), cell.getCol(), bktPathColor);
			} else {
				mc.erasePath(cell.getRow(), cell.getCol(), side);
				mc.eraseCenter(cell.getRow(), cell.getCol());
			}
		}
	}

}
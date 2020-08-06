import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

import graphics.MazeCanvas;
import graphics.MazeCanvas.Side;

public class Solver {
	private MazeCanvas mc;
	private Maze mz;
	private static final Color fwdPathColor = new Color(74, 255, 216);
	private static final Color bktPathColor = new Color(165, 126, 224);
	private static final Color generateHeadColor = new Color(0, 0, 0);

	public Solver(MazeCanvas _mc, Maze _mz) {
		mc = _mc;
		mz = _mz;
	}

	public boolean run(Cell cell, Side side) {
		cell.setVisited(true);
		mc.drawPath(cell.getRow(),cell.getCol(),side,fwdPathColor);
		mc.drawCenter(cell.getRow(), cell.getCol(), fwdPathColor);
		mc.drawCenter(cell.getRow(), cell.getCol(), generateHeadColor);
		if(cell==mz.getExitCell())
			return true;
		ArrayList<Side> listOfPaths=shuffle(cell.getPaths());
		for(Side latura:listOfPaths) {
			Cell vecin=mz.getNeighbor(cell, latura);
			if(!vecin.getVisited()) {
				mc.drawPath(cell.getRow(), cell.getCol(), latura, fwdPathColor);
				mc.step(10);
				if(run(vecin,getOpposite(latura)))
					return true;
				mc.drawPath(cell.getRow(), cell.getCol(), latura, bktPathColor);
			}
		}
		mc.drawCenter(cell.getRow(),cell.getCol(),bktPathColor);
		mc.drawPath(cell.getRow(),cell.getCol(),side,bktPathColor);
		return false;
	}

	public boolean run() {
		for (int row = 0; row < mc.getRows(); ++row)
			for (int col = 0; col < mc.getCols(); ++col)
				mz.getCell(row, col).setVisited(false);
		return (run(mz.getEntryCell(), Side.Center));
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
}

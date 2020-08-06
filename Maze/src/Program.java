import graphics.MazeCanvas;

public class Program {

	public static final int NROWS = 38;
	public static final int NCOLS = 54;
	public static final int CELL_SIZE = 20;

	public static void main(String[] args) {

		MazeCanvas mc = new MazeCanvas(NROWS, NCOLS, CELL_SIZE);
		mc.open();
		Maze m = new Maze(mc);

		m.genSnake();
		mc.pause();

		m.initialize();
		mc.pause();

		Generator generator = new Generator(mc, m);
		generator.run();
		mc.pause();
	}

}

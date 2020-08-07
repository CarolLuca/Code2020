import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import audio.AudioPlayer;
import graphics.MazeCanvas;

public class Program {

	public static final int NROWS = 38;
	public static final int NCOLS = 54;
	public static final int CELL_SIZE = 20;

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		MazeCanvas mc = new MazeCanvas(NROWS, NCOLS, CELL_SIZE);
		mc.open();
		Maze m = new Maze(mc);

		m.genSnake();
		mc.pause();

		m.initialize();
		mc.pause();
		
		new AudioPlayer("tetris-gameboy-01 (online-audio-converter.com).wav");
		
		Generator generator = new Generator(mc, m);
		generator.run();
		mc.pause();

		Solver solver = new Solver(mc, m);
		solver.run();
		mc.pause();
		
	}

}

import graphics.Graphics;

public class Program {

	public static final int latMare = 300, latmica = 10;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] ok = new boolean[10000][10000];

	public static void spirala(int x, int y, int nr, int d, int total) {
		if (total % 2 == 0) {
			Graphics.cafeWall.drawDarkSquare(x, y, latmica);
		} else {
			Graphics.cafeWall.drawBrightSquare(x, y, latmica);
		}
		Graphics.cafeWall.step();
		--nr;
		ok[x][y] = true;
		int xx = x + dx[d] * latmica;
		int yy = y + dy[d] * latmica;
		if (ok[xx][yy] == true || nr == 0) {
			d = (d + 1) % 4;
			xx = x + dx[d] * latmica;
			yy = y + dy[d] * latmica;
			nr = latMare / latmica-1;
		}
		if (ok[xx][yy] == true)
			return;
		spirala(xx, yy, nr, d, total + 1);
	}

	public static void main(String[] args) {
		Graphics.cafeWall.open();
		spirala(50, 50, latMare / latmica, 0, 0);
		Graphics.cafeWall.pause();
		Graphics.cafeWall.close();
	}
}

import java.awt.*;

public class Game {
	static DrawGrid d;
	static Graphics g;

	public static void main(String[] args) {
		d = new DrawGrid();
		DrawingPanel panel = DrawGrid.getPanel();
		g = panel.getGraphics();
	}
}

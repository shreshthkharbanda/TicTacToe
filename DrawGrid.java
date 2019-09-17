import java.awt.*;

public class DrawGrid {
	public static final int xSize = 650;
	public static final int ySize = 400;
	public static int col1 = xSize / 3;
	public static int col2 = col1 * 2;
	public static int row1 = ySize / 3;
	public static int row2 = row1 * 2;
	private static DrawingPanel panel = new DrawingPanel(xSize, ySize);
	public static Graphics g = getPanel().getGraphics();

	public static final int SIZE = 150;
	static String shape = "X";

	static int square1X = DrawGrid.col1 / 2 - SIZE / 3;
	static int square2X = (DrawGrid.col2 - DrawGrid.col1) / 2 + DrawGrid.col1 - SIZE / 3;
	static int square3X = (panel.getWidth() - DrawGrid.col2) / 2 + DrawGrid.col2 - SIZE / 3;
	static int row1Y = DrawGrid.row1 / 2 + SIZE / 3;
	static int row2Y = (DrawGrid.row2 - DrawGrid.row1) / 2 + DrawGrid.row1 + SIZE / 3;
	static int row3Y = (DrawGrid.row2 - DrawGrid.row1) / 2 + DrawGrid.row2 + SIZE / 3;

	static Game game = new Game();

	DrawGrid() {
//		setPanel(new DrawingPanel(xSize, ySize));
//		getPanel().setBackground(Color.WHITE);
//		g = getPanel().getGraphics();

		drawColumns();
		drawRows();
	}

	public void drawColumns() {
		g.drawLine(col1, 0, col1, ySize);
		g.drawLine(col2, 0, col2, ySize);
	}

	public void drawRows() {
		g.drawLine(0, row1, xSize, row1);
		g.drawLine(0, row2, xSize, row2);
	}

	public static DrawingPanel getPanel() {
		return panel;
	}

	public void setPanel(DrawingPanel panel) {
		DrawGrid.panel = panel;
	}

	public static void drawShape(int x, int y) {

		if (Game.checkGrid() == false) {
			g.setFont(new Font("Arial", Font.CENTER_BASELINE, SIZE));

			if (x < DrawGrid.col1 && y < DrawGrid.row1 && !Game.getMap().get(1).equals(shape)) {
				g.drawString(shape, square1X, row1Y);
				Game.getMap().put(1, shape);
			} else if ((x > DrawGrid.col1 && x < DrawGrid.col2) && y < DrawGrid.row1) {
				g.drawString(shape, square2X, row1Y);
				Game.getMap().put(2, shape);
			} else if (x > DrawGrid.col2 && y < DrawGrid.row1) {
				g.drawString(shape, square3X, row1Y);
				Game.getMap().put(3, shape);
			}

			if (x < DrawGrid.col1 && (y < DrawGrid.row2 && y > DrawGrid.row1)) {
				g.drawString(shape, square1X, row2Y);
				Game.getMap().put(4, shape);
			} else if ((x > DrawGrid.col1 && x < DrawGrid.col2) && (y < DrawGrid.row2 && y > DrawGrid.row1)) {
				g.drawString(shape, square2X, row2Y);
				Game.getMap().put(5, shape);
			} else if (x > DrawGrid.col2 && (y < DrawGrid.row2 && y > DrawGrid.row1)) {
				g.drawString(shape, square3X, row2Y);
				Game.getMap().put(6, shape);
			}

			if (x < DrawGrid.col1 && y > DrawGrid.row2) {
				g.drawString(shape, square1X, row3Y);
				Game.getMap().put(7, shape);
			} else if ((x > DrawGrid.col1 && x < DrawGrid.col2) && y > DrawGrid.row2) {
				g.drawString(shape, square2X, row3Y);
				Game.getMap().put(8, shape);
			} else if (x > DrawGrid.col2 && y > DrawGrid.row2) {
				g.drawString(shape, square3X, row3Y);
				Game.getMap().put(9, shape);
			}
			shape = shape == "X" ? "O" : "X";
		}
	}
}
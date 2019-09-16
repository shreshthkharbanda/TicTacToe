import java.awt.*;

public class DrawGrid {
	public static final int xSize = 650;
	public static final int ySize = 400;
	public static int col1 = xSize / 3;
	public static int col2 = col1 * 2;
	public static int row1 = ySize / 3;
	public static int row2 = row1 * 2;
	public static Graphics g;
	private static DrawingPanel panel;

	DrawGrid() {
		setPanel(new DrawingPanel(xSize, ySize));
		getPanel().setBackground(Color.WHITE);
		g = getPanel().getGraphics();

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
		return DrawGrid.panel;
	}

	public void setPanel(DrawingPanel panel) {
		DrawGrid.panel = panel;
	}
}
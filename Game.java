import java.awt.*;

public class Game {
	static DrawGrid d;
	static Graphics g;
	static DrawingPanel panel;
	public static final int SIZE = 150;

	public static void main(String[] args) {
		d = new DrawGrid();
		panel = DrawGrid.getPanel();
		g = panel.getGraphics();
		
		panel.onClick((x, y) -> drawShape(x, y));
	}

	private static void drawShape(int x, int y) {
		g.setFont(new Font("Arial", Font.CENTER_BASELINE, SIZE));
		
		if(x < DrawGrid.col1 && y < DrawGrid.row1)
			g.drawString("X", DrawGrid.col1/2 - SIZE/3, DrawGrid.row1/2 + SIZE/3);
		if((x > DrawGrid.col1 && x < DrawGrid.col2) && y < DrawGrid.row1)
			g.drawString("X", (DrawGrid.col2 - DrawGrid.col1)/2 + DrawGrid.col1 - SIZE/3, DrawGrid.row1/2 + SIZE/3);
		if(x > DrawGrid.col2 && y < DrawGrid.row1)
			g.drawString("X", (panel.getWidth() - DrawGrid.col2)/2 + DrawGrid.col2 - SIZE/3, DrawGrid.row1/2 + SIZE/3);
		
		if(x < DrawGrid.col1 && (y < DrawGrid.row2 && y > DrawGrid.row1))
				g.drawString("X", DrawGrid.col1/2 - SIZE/3, (DrawGrid.row2 - DrawGrid.row1)/2 + DrawGrid.row1 + SIZE/3);
		if((x > DrawGrid.col1 && x < DrawGrid.col2) && (y < DrawGrid.row2 && y > DrawGrid.row1))
			g.drawString("X", (DrawGrid.col2 - DrawGrid.col1)/2 + DrawGrid.col1 - SIZE/3, (DrawGrid.row2 - DrawGrid.row1)/2 + DrawGrid.row1 + SIZE/3);
		if(x > DrawGrid.col2 && (y < DrawGrid.row2 && y > DrawGrid.row1))
			g.drawString("X", (panel.getWidth() - DrawGrid.col2)/2 + DrawGrid.col2 - SIZE/3, (DrawGrid.row2 - DrawGrid.row1)/2 + DrawGrid.row1 + SIZE/3);
		
		if(x < DrawGrid.col1 && y > DrawGrid.row2)
			g.drawString("X", DrawGrid.col1/2 - SIZE/3, (DrawGrid.row2 - DrawGrid.row1)/2 + DrawGrid.row2 + SIZE/3);
		if((x > DrawGrid.col1 && x < DrawGrid.col2) && y > DrawGrid.row2)
			g.drawString("X", (DrawGrid.col2 - DrawGrid.col1)/2 + DrawGrid.col1 - SIZE/3, (DrawGrid.row2 - DrawGrid.row1)/2 + DrawGrid.row2 + SIZE/3);
		if(x > DrawGrid.col2 && y > DrawGrid.row2)
			g.drawString("X", (panel.getWidth() - DrawGrid.col2)/2 + DrawGrid.col2 - SIZE/3, (DrawGrid.row2 - DrawGrid.row1)/2 + DrawGrid.row2 + SIZE/3);
	}
}
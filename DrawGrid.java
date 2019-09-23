import java.awt.*;
import javax.swing.JOptionPane;

/*
 Rename this file to GameDisplay
*/

public class DrawGrid {
	public static final int xSize = 450;
	public static final int ySize = 450;
	public static int col1 = xSize / 3;
	public static int col2 = col1 * 2;
	public static int row1 = ySize / 3;
	public static int row2 = row1 * 2;
	public static final int SIZE = 175;
	String shape = "X";
	boolean isGameOver = false;
	
	
	private DrawingPanel panel = new DrawingPanel(xSize, ySize);
	public Graphics g = getPanel().getGraphics();

	static Game game = new Game();

	DrawGrid() {
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

	public DrawingPanel getPanel() {
		return panel;
	}


	public void drawShape(int x, int y) {
		int cellX = (x / 150);
		int cellY = (y / 150);
		int cell = cellX + (cellY*3);

		if (!isGameOver) {
			g.setFont(new Font("Arial", Font.CENTER_BASELINE, SIZE));

			if (Game.getMap()[cell] == 0) {
				g.drawString(shape, (cellX * (xSize/3)) + 15, (cellY * (ySize/3)) + 135);
				System.out.println("x = " + ((cellX * (xSize/3)) + 15) + "\n y = " + ((cellY * (ySize/3)) + 135));
				Game.getMap()[cell] = shape == "X" ? 1 : 2;
				shape = shape == "X" ? "O" : "X";
			}

			isGameOver = Game.checkGrid();
		}
	}

	public void playAgain(String winner){
		int answer = JOptionPane.showConfirmDialog(null, "Would you like to play again?",winner, JOptionPane.YES_NO_OPTION);
		if(answer == 0){
			Game.closePrev();
			Game.startGame();
		}else{
			System.exit(0);
		}
	}
}

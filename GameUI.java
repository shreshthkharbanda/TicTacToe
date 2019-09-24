/**
 * 
 * @author Shantanu Singh & Shreshth Kharbanda
 * Advance Programming Topics
 * Period 3
 * TicTacToe
 * 
 * The GameUI class is responsible for displaying and setting up all the features
 * of the game interface, such as making the grid, drawing the shapes, and the
 * choice dialog.
 * 
 */
import java.awt.*;
import javax.swing.JOptionPane;

public class GameUI {
	public static final int xSize = 450;
	public static final int ySize = 450;
	public static int col1 = xSize / 3;
	public static int col2 = col1 * 2;
	public static int row1 = ySize / 3;
	public static int row2 = row1 * 2;
	public static final int SIZE = 175;
	String shape = "X";
	String winner = "";
	boolean isGameOver = false;

	private DrawingPanel panel = new DrawingPanel(xSize, ySize);
	public Graphics g = getPanel().getGraphics();

	GameUI() {
		drawGrid();
	}

	public void drawGrid() {
		panel.clear();
		// Cols
		g.setColor(Color.BLACK);
		g.drawLine(col1, 0, col1, ySize);
		g.drawLine(col2, 0, col2, ySize);
		// Rows
		g.drawLine(0, row1, xSize, row1);
		g.drawLine(0, row2, xSize, row2);
	}

	public DrawingPanel getPanel() {
		return panel;
	}

	public void drawShape(int x, int y) {
		int cellX = (x / 150);
		int cellY = (y / 150);
		int cell = cellX + (cellY * 3);

		if (!isGameOver) {
			g.setFont(new Font("Arial", Font.CENTER_BASELINE, SIZE));

			if (GameEngine.getMap()[cell] == 0) {
				g.drawString(shape, (cellX * (xSize / 3)) + 15, (cellY * (ySize / 3)) + 135);
				System.out.println("x = " + ((cellX * (xSize / 3)) + 15) + "\n y = " + ((cellY * (ySize / 3)) + 135));
				GameEngine.getMap()[cell] = shape == "X" ? 1 : 2;
				shape = shape == "X" ? "O" : "X";
			}

			isGameOver = GameEngine.winCombos();
		}
		if (isGameOver) {
			playAgain(this.winner);
		}
	}

	public void playAgain(String winner) {
		int answer = JOptionPane.showConfirmDialog(null, "Would you like to play again?", winner,
				JOptionPane.YES_NO_OPTION);
		if (answer == 0) {
			isGameOver = false;
			GameEngine.startGame();
		} else {
			System.exit(0);
		}
	}
}

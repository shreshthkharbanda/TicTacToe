/**
 * 
 * @author Shantanu Singh and Shreshth Kharbanda
 * Advance Programming Topics
 * Period 3
 * TicTacToe
 * 
 * The GameUI class is responsible for displaying and setting up all the features
 * of the game interface, such as making the grid, drawing the shapes, and the
 * choice dialog.
 */
import java.awt.*;
import javax.swing.JOptionPane;

public class GameUI {
	// Constants for the dimensions of each square and the whole grid
	private final int xSize = 450;
	private final int ySize = 450;
	private int col1 = xSize / 3;
	private int col2 = col1 * 2;
	private int row1 = ySize / 3;
	private int row2 = row1 * 2;
	private final int SIZE = 175;
	// initializes variable shape, used to draw on the grid
	String shape = "X";
	// defines the winner variable
	String winner = "";
	// initializes variable isGameOver to false, it changes to true when a user wins or the game ends in a draw
	boolean isGameOver = false;

	// creates a DrawingPanel with the dimensions, and initializes it to variable panel
	private DrawingPanel panel = new DrawingPanel(xSize, ySize);
	// initializes the graphics of the panel to g
	public Graphics g = getPanel().getGraphics();

	// Constructor for GameUI, which draws an empty 3x3 grid.
	GameUI() {
		drawGrid();
	}
	/**
	 * empties the screen, then draws columns and rows
	 */
	public void drawGrid() {
		// Clears the panel
		panel.clear();
		// Draws the columns on the panel
		g.setColor(Color.BLACK);
		g.drawLine(col1, 0, col1, ySize);
		g.drawLine(col2, 0, col2, ySize);
		// Draws the rows on the panel
		g.drawLine(0, row1, xSize, row1);
		g.drawLine(0, row2, xSize, row2);
	}

	/**
	 * getPanel is a getter to get the value of panel
	 * @return panel - the variable that contains the DrawingPanel
	 */
	public DrawingPanel getPanel() {
		return panel;
	}

	/**
	 * drawShape draws an X or O, depending on who's turn it is.
	 * It checks if the game is over or not. 
	 * If not, it checks where the user clicked, and assigns a square to it. 
	 * Based on that, it draws the shape in the middle of that square.
	 * 
	 * @param x the x coordinate of the mouse click
	 * @param y the y coordinate of the mouse click
	 */
	public void drawShape(int x, int y) {
		// get the cell's x value, y value, and cell number
		int cellX = (x / 150);
		int cellY = (y / 150);
		int cell = cellX + (cellY * 3);

		if (!isGameOver) {
			// set custom font
			g.setFont(new Font("Arial", Font.CENTER_BASELINE, SIZE));
			
			// if there is no value there, draw the shape in the corresponding cell
			if (GameEngine.getMap()[cell] == 0) {
				g.drawString(shape, (cellX * (xSize / 3)) + 15, (cellY * (ySize / 3)) + 135);
				System.out.println("x = " + ((cellX * (xSize / 3)) + 15) + "\n y = " + ((cellY * (ySize / 3)) + 135));
				GameEngine.getMap()[cell] = shape == "X" ? 1 : 2;
				// change the shape variable
				shape = shape == "X" ? "O" : "X";
			}
			// check if a user won, or it is a draw
			isGameOver = GameEngine.winCombos();
		}
		if (isGameOver) {
			// if game is over, ask user to play again
			playAgain(this.winner);
		}
	}


	/**
	 * playAgain asks the user if they would like to play again.
	 * If they would like to, the game is reset
	 * 
	 * @param winner who won the game
	 */
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
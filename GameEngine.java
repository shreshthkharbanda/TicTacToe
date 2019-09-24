/**
 * 
 * @author Shantanu Singh and Shreshth Kharbanda
 * Advanced Programming Topics
 * Period 3
 * TicTacToe
 * 
 * The GameEngine class is responsible for handling all of the games logical components,
 * such as checking for winner and resetting the game and its values.
 * 
 */

public class GameEngine {
	
	/*  These are all the class variables, made global
		to ease the process of passing them around in multiple methods.
		Simplifies the process by eliminating the step of creating parameters 
		for each method that utilize these variables	*/
	private static GameUI board;
	private static DrawingPanel panel;
	private static String winner;

	// Array map holds the spots already occupied on the board
	static int[] map;
	static String[] shapes = { "X", "O" };

	/**
	 * Main Method is responsible for initializing the GameUI object, 
	 * as well as set the onClick event handler. Calls startGame method to start
	 * the game. 
	 * @param args parameter passed into main method
	 */
	public static void main(String[] args) {
		board = new GameUI();
		panel = board.getPanel();
		panel.onClick((x, y) -> board.drawShape(x, y));

		startGame();
	}

	/**
	 * getMap Method allows other classes to access the array filled with
	 * the postions of each shape.
	 * 
	 * @return map - Array containing all spots that have already have a shape
	 */
	public static int[] getMap() {
		return map;
	}

	/**
	 * winCombos Methods is called upon when needing to check if there is a winner,
	 * calls upon three helper methods to split the task of checking.
	 * 
	 * @return boolean - boolean represents whether the game should end or continue.
	 */
	public static boolean winCombos() {
		// Checks if there is a win in any row or column or diagonal
		if (checkRows() || checkCols() || checkDiag()) {
			board.winner = winner + " Wins!";
			return true;
		// Checks for if there is a draw in the game
		} else if (checkDraw()) {
			board.winner = "Its a Draw";
			return true;
		}
		return false;
	}

	/**
	 * 
	 * checkRows Methods is a helper method that helps check for a winner in all
	 * rows.
	 * 
	 * @return boolean = boolean representing whether the it found a winning combo or not
	 */
	private static boolean checkRows() {
		// Checks all possible row combonations for a win
		if ((map[0] != 0) && (map[0] == (map[1]) && map[1] == (map[2]))) {
			winner = shapes[map[0] - 1];
			return true;
		} else if ((map[3] != 0) && map[3] == (map[4]) && map[4] == (map[5])) {
			winner = shapes[map[3] - 1];
			return true;
		} else if ((map[6] != 0) && map[6] == (map[7]) && map[7] == (map[8])) {
			winner = shapes[map[6] - 1];
			return true;
		}
		return false;
	}

	/**
	 * 
	 * checkCols Methods is a helper method that helps check for a winner in all
	 * columns.
	 * 
	 * @return boolean = boolean representing whether the it found a winning combo or not
	 */
	private static boolean checkCols() {
		// Checks all possible column combonations for a win
		if ((map[0] != 0) && map[0] == (map[3]) && map[3] == (map[6])) {
			winner = shapes[map[0] - 1];
			return true;
		} else if ((map[1] != 0) && map[1] == (map[4]) && map[4] == (map[7])) {
			winner = shapes[map[1] - 1];
			return true;
		} else if ((map[2] != 0) && map[2] == (map[5]) && map[5] == (map[8])) {
			winner = shapes[map[2] - 1];
			return true;
		}
		return false;
	}

	/**
	 * 
	 * checkDiag Method is a helper method that checks both diagnol win 
	 * combonations.
	 * 
	 * @return boolean = boolean representing whether the it found a winning combo or not
	 */
	private static boolean checkDiag() {
		// Checks all possible win combos diagonally
		if ((map[0] != 0) && map[0] == (map[4]) && map[4] == (map[8])) {
			winner = shapes[map[0] - 1];
			return true;
		} else if ((map[2] != 0) && map[2] == (map[4]) && map[4] == (map[6])) {
			winner = shapes[map[2] - 1];
			return true;
		}
		return false;
	}

	/**
	 * checkDraw method is a helper method that also helps in checking for if the game
	 * has ended in a draw
	 * 
	 * @return  boolean = boolean representing whether the it found a draw combo or not
	 */
	private static boolean checkDraw() {
		/* For loop iterates through each element of Array map and
		   checks to see if there are any open spots left, 
		   if so then it returns false */
		for (int i = 0; i < map.length; i++) {
			if (map[i] == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * startGame Method is responsible for setting up the grid and class variables 
	 * to the correct state for a new game to start and function properly.
	 */
	public static void startGame() {
		// Starts off with setting the Array map back to all empty spots
		map = new int[9];
		// sets starting letter in class GameUI to "X"
		board.shape = "X";
		// Tells GameUi object board to draw a new empty grid
		board.drawGrid();

	}

}
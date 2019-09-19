import java.awt.*;
import java.util.*;

public class Game {
	static DrawGrid d = new DrawGrid();
	static DrawingPanel panel = DrawGrid.getPanel();
	static Graphics g = panel.getGraphics();

	static int[] map = new int[9];

	public static void main(String[] args) {
		panel.onClick((x, y) -> DrawGrid.drawShape(x, y));
	}

	public static int[] getMap() {
		return map;
	}

	public static boolean checkGrid() {
		try {
			return winCombos();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean winCombos() {
		System.out.println(Arrays.toString(map));
		// Find way to continue checking for win combos even if some values are null
		// Only issue with the actual game
		if ((map[0] != 0) && (map[0] == (map[1]) && map[1] == (map[2]))) {
			System.out.println(map[0] + " WINS!");
			return true;
		} else if ((map[3] != 0) && map[3] == (map[4]) && map[4] == (map[5])) {
			System.out.println(map[3] + " WINS!");
			return true;
		} else if ((map[6] != 0) && map[6] == (map[7]) && map[7] == (map[8])) {
			System.out.println(map[6] + " WINS!");
			return true;
		} else if ((map[0] != 0) && map[0] == (map[3]) && map[3] == (map[6])) {
			System.out.println(map[0] + " WINS!");
			return true;
		} else if ((map[1] != 0) && map[1] == (map[4]) && map[4] == (map[7])) {
			System.out.println(map[0] + " WINS!");
			return true;
		} else if ((map[2] != 0) && map[2] == (map[5]) && map[5] == (map[8])) {
			System.out.println(map[0] + " WINS!");
			return true;
		} else if ((map[0] != 0) && map[0] == (map[4]) && map[4] == (map[8])) {
			System.out.println(map[0] + " WINS!");
			return true;
		} else if ((map[2] != 0) && map[2] == (map[4]) && map[4] == (map[6])) {
			System.out.println(map[0] + " WINS!");
			return true;
		}
		return false;
	}

}
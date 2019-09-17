import java.awt.*;
import java.util.*;

public class Game {
	static DrawGrid d = new DrawGrid();
	static DrawingPanel panel = DrawGrid.getPanel();
	static Graphics g = panel.getGraphics();

	static HashMap<Integer, String> map = new HashMap<Integer, String>();

	public static void main(String[] args) {
		panel.onClick((x, y) -> DrawGrid.drawShape(x, y));
	}

	public static HashMap<Integer, String> getMap() {
		return map;
	}
	
	public static boolean checkGrid() {
		try {
			
			
			if (map.get(1).equals(map.get(2)) && map.get(2).equals(map.get(3))) {
				System.out.println(map.get(1) + " WINS!");
				return true;
			}
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}
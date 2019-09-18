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
			return winCombos();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean winCombos(){
		System.out.println(map.keySet().toString());
		// Find way to continue checking for win combos even if some values are null
		// Only issue with the actual game
		if(map.get(1).equals(map.get(2)) && map.get(2).equals(map.get(3))){
			System.out.println(map.get(1) + " WINS!");
			return true;
		}else if(map.get(4).equals(map.get(5)) && map.get(5).equals(map.get(6))){
			System.out.println(map.get(4) + " WINS!");
			return true;
		}else if(map.get(7).equals(map.get(8)) && map.get(8).equals(map.get(9))){
			System.out.println(map.get(7) + " WINS!");
			return true;
		}else if(map.get(1).equals(map.get(4)) && map.get(4).equals(map.get(7))){
			System.out.println(map.get(1) + " WINS!");
			return true;
		}else if(map.get(2).equals(map.get(5)) && map.get(5).equals(map.get(8))){
			System.out.println(map.get(1) + " WINS!");
			return true;
		}else if(map.get(3).equals(map.get(6)) && map.get(6).equals(map.get(9))){
			System.out.println(map.get(1) + " WINS!");
			return true;
		}else if(map.get(1).equals(map.get(5)) && map.get(5).equals(map.get(9))){
			System.out.println(map.get(1) + " WINS!");
			return true;
		}else if(map.get(3).equals(map.get(5)) && map.get(5).equals(map.get(7))){
			System.out.println(map.get(1) + " WINS!");
			return true;
		}
		return false;
	}

}

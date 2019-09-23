public class Game {

	public static DrawGrid d;
	public static DrawingPanel panel;
	public static String winner;

	static int[] map;
	static String[] shapes = {"X", "O"};

	public static void main(String[] args) {
		startGame();
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
		if(checkRows() || checkCols() || checkVert()){
			d.playAgain(winner  + " Wins");
			return true;
		}else if(checkDraw()){
			d.playAgain("It's a Draw");
			return true;
		}
		return false;
	}

	private static boolean checkRows(){
		if ((map[0] != 0) && (map[0] == (map[1]) && map[1] == (map[2]))) {
			winner = shapes[map[0]-1];
			return true;
		} else if ((map[3] != 0) && map[3] == (map[4]) && map[4] == (map[5])) {
			winner = shapes[map[3]-1];
			return true;
		} else if ((map[6] != 0) && map[6] == (map[7]) && map[7] == (map[8])) {
			winner = shapes[map[6]-1];
			return true;
		}
		return false;
	}

	private static boolean checkCols(){
		if ((map[0] != 0) && map[0] == (map[3]) && map[3] == (map[6])) {
			winner = shapes[map[0]-1];
			return true;
		} else if ((map[1] != 0) && map[1] == (map[4]) && map[4] == (map[7])) {
			winner = shapes[map[1]-1];
			return true;
		} else if ((map[2] != 0) && map[2] == (map[5]) && map[5] == (map[8])) {
			winner = shapes[map[2]-1];
			return true;
		}
		return false;
	}

	private static boolean checkVert(){
		if ((map[0] != 0) && map[0] == (map[4]) && map[4] == (map[8])) {
			winner = shapes[map[0]-1];
			return true;
		} else if ((map[2] != 0) && map[2] == (map[4]) && map[4] == (map[6])) {
			winner = shapes[map[2]-1];
			return true;
		}
		return false;
	}

	private static boolean checkDraw(){
		for(int i = 0; i < map.length;i++){
			if(map[i] == 0){
				return false;
			}
		}
		return true;
	}

	public static void startGame(){
		map = new int[9];
		d = new DrawGrid();
		panel = d.getPanel();
		panel.onClick((x, y) -> d.drawShape(x, y));
	}

	public static void closePrev() {
		panel.setVisible(false);
	}

}

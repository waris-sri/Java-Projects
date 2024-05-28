
public class Cube {
	String[][] front = new String[3][3]; 
	String[][] back = new String[3][3];
	String[][] left = new String[3][3];
	String[][] right = new String[3][3];
	String[][] up = new String[3][3];
	String[][] down = new String[3][3];

	Cube() {
		insertAll("Y",up);
		insertAll("W",down);
		insertAll("R",front);
		insertAll("G",right);
		insertAll("B",left);
		insertAll("O",back);
	}
	
	private static String[][] insertAll(String str, String matrix[][]){
		for(int i = 0 ;i < matrix.length ; i++) {
			for(int j = 0; j < matrix[i].length;j++) {
				matrix[i][j] = str;
			}
		}
		return matrix;
	}
	
	void left() {
		String temp00 = up[0][0];
		String temp10 = up[1][0];
		String temp20 = up[2][0];
		up[0][0] = back[0][0];
		up[1][0] = back[1][0];
		up[2][0] = back[2][0];
		back[0][0] = down[0][0];
		back[1][0] = down[2][0];
		back[2][0] = down[2][0];
		down[0][0] = front[0][0];
		down[1][0] = front[1][0];
		down[2][0] = front[2][0];
		front[0][0] = temp00;
		front[1][0] = temp10;
		front[2][0] = temp20;
		temp00 = left[0][0];
		temp10 = left[1][0];
		left[0][0] = left[2][0];
		left[1][0] = left[2][1];
		left[2][0] = left[2][2];
		left[2][1] = left[1][2];
		left[2][2] = left[0][2];
		left[1][2] = left[0][1];
		left[0][2] = temp00;
		left[0][1] = temp10;
	}
	
	void leftPrime() {
		String temp00 = up[0][0];
		String temp10 = up[1][0];
		String temp20 = up[2][0];
		up[0][0] = front[0][0];
		up[1][0] = front[1][0];
		up[2][0] = front[2][0];
		front[0][0] = down[0][0];
		front[1][0] = down[2][0];
		front[2][0] = down[2][0];
		down[0][0] = back[0][0];
		down[1][0] = back[1][0];
		down[2][0] = back[2][0];
		back[0][0] = temp00;
		back[1][0] = temp10;
		back[2][0] = temp20;
		temp00 = left[0][0];
		temp10 = left[1][0];
		left[0][0] = left[0][2];
		left[1][0] = left[0][1];
		left[0][2] = left[2][2];
		left[0][1] = left[1][2];
		left[2][2] = left[2][0];
		left[1][2] = left[2][1];
		left[2][0] = temp00;
		left[2][1] = temp10;
	}
	
	void y() {
		String[][] temp = front;
		front = right;
		right = back;
		back = left;
		left = temp;
		String temp00 = up[0][0];
		String temp10 = up[1][0];
		up[0][0] = up[2][0];
		up[1][0] = up[2][1];
		up[2][0] = up[2][2];
		up[2][1] = up[1][2];
		up[2][2] = up[0][2];
		up[1][2] = up[0][1];
		up[0][2] = temp00;
		up[0][1] = temp10;
		temp00 = down[0][0];
		temp10 = down[1][0];
		down[0][0] = down[2][0];
		down[1][0] = down[2][1];
		down[2][0] = down[2][2];
		down[2][1] = down[1][2];
		down[2][2] = down[0][2];
		down[1][2] = down[0][1];
		down[0][2] = temp00;
		down[0][1] = temp10;
	}
	
	void print() {
		for(String[] i : back) {
			System.out.println("");
			for(int k = 0 ; k < 6; k++) {
				System.out.print(" ");
			}
			for(String j : i) {
				System.out.print(" "+j);
			}
		}
		for(int i = 0; i < 3 ; i++) {
			System.out.println("");
			for(String j : left[i]) {
				System.out.print(" "+j);
			}
			for(String j : up[i]) {
				System.out.print(" "+j);
			}
			for(String j : right[i]) {
				System.out.print(" "+j);
			}
		}
		for(String[] i : front) {
			System.out.println("");
			for(int k = 0 ; k < 6; k++) {
				System.out.print(" ");
			}
			for(String j : i) {
				System.out.print(" "+j);
			}
		}
		for(String[] i : down) {
			System.out.println("");
			for(int k = 0 ; k < 6; k++) {
				System.out.print(" ");
			}
			for(String j : i) {
				System.out.print(" "+j);
			}
		}
	}
	
}

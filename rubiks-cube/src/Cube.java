public class Cube {
	String[][] f = new String[3][3];
	String[][] b = new String[3][3];
	String[][] l = new String[3][3];
	String[][] r = new String[3][3];
	String[][] u = new String[3][3];
	String[][] d = new String[3][3];

	Cube() {
		insertAll("Y", u);
		insertAll("W", d);
		insertAll("R", f);
		insertAll("G", r);
		insertAll("B", l);
		insertAll("O", b);
	}

	private static String[][] insertAll(String str, String matrix[][]) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = str;
			}
		}
		return matrix;
	}

	void l() {
		String temp00 = u[0][0];
		String temp10 = u[1][0];
		String temp20 = u[2][0];
		u[0][0] = b[0][0];
		u[1][0] = b[1][0];
		u[2][0] = b[2][0];
		b[0][0] = d[0][0];
		b[1][0] = d[2][0];
		b[2][0] = d[2][0];
		d[0][0] = f[0][0];
		d[1][0] = f[1][0];
		d[2][0] = f[2][0];
		f[0][0] = temp00;
		f[1][0] = temp10;
		f[2][0] = temp20;
		temp00 = l[0][0];
		temp10 = l[1][0];
		l[0][0] = l[2][0];
		l[1][0] = l[2][1];
		l[2][0] = l[2][2];
		l[2][1] = l[1][2];
		l[2][2] = l[0][2];
		l[1][2] = l[0][1];
		l[0][2] = temp00;
		l[0][1] = temp10;
		System.out.println("");
	}

	void lP() {
		String temp00 = u[0][0];
		String temp10 = u[1][0];
		String temp20 = u[2][0];
		u[0][0] = f[0][0];
		u[1][0] = f[1][0];
		u[2][0] = f[2][0];
		f[0][0] = d[0][0];
		f[1][0] = d[2][0];
		f[2][0] = d[2][0];
		d[0][0] = b[0][0];
		d[1][0] = b[1][0];
		d[2][0] = b[2][0];
		b[0][0] = temp00;
		b[1][0] = temp10;
		b[2][0] = temp20;
		temp00 = l[0][0];
		temp10 = l[1][0];
		l[0][0] = l[0][2];
		l[1][0] = l[0][1];
		l[0][2] = l[2][2];
		l[0][1] = l[1][2];
		l[2][2] = l[2][0];
		l[1][2] = l[2][1];
		l[2][0] = temp00;
		l[2][1] = temp10;
		System.out.println("");
	}

	void m() {
		String temp00 = u[0][1];
		String temp10 = u[1][1];
		String temp20 = u[2][1];
		u[0][1] = b[0][1];
		u[1][1] = b[1][1];
		u[2][1] = b[2][1];
		b[0][1] = d[0][1];
		b[1][1] = d[2][1];
		b[2][1] = d[2][1];
		d[0][1] = f[0][1];
		d[1][1] = f[1][1];
		d[2][1] = f[2][1];
		f[0][1] = temp00;
		f[1][1] = temp10;
		f[2][1] = temp20;
		temp00 = l[0][0];
		temp10 = l[1][0];
		l[0][0] = l[2][0];
		l[1][0] = l[2][1];
		l[2][0] = l[2][2];
		l[2][1] = l[1][2];
		l[2][2] = l[0][2];
		l[1][2] = l[0][1];
		l[0][2] = temp00;
		l[0][1] = temp10;
		System.out.println("");
	}

	void mP() {
		String temp00 = u[0][1];
		String temp10 = u[1][1];
		String temp20 = u[2][1];
		u[0][1] = f[0][1];
		u[1][1] = f[1][1];
		u[2][1] = f[2][1];
		f[0][1] = d[0][1];
		f[1][1] = d[2][1];
		f[2][1] = d[2][1];
		d[0][1] = b[0][1];
		d[1][1] = b[1][1];
		d[2][1] = b[2][1];
		b[0][1] = temp00;
		b[1][1] = temp10;
		b[2][1] = temp20;
		temp00 = l[0][0];
		temp10 = l[1][0];
		l[0][0] = l[2][0];
		l[1][0] = l[2][1];
		l[2][0] = l[2][2];
		l[2][1] = l[1][2];
		l[2][2] = l[0][2];
		l[1][2] = l[0][1];
		l[0][2] = temp00;
		l[0][1] = temp10;
		System.out.println("");
	}

	void r() {
		String temp00 = u[0][2];
		String temp10 = u[1][2];
		String temp20 = u[2][2];
		u[0][2] = b[0][2];
		u[1][2] = b[1][2];
		u[2][2] = b[2][2];
		b[0][2] = d[0][2];
		b[1][2] = d[2][2];
		b[2][2] = d[2][2];
		d[0][2] = f[0][2];
		d[1][2] = f[1][2];
		d[2][2] = f[2][2];
		f[0][2] = temp00;
		f[1][2] = temp10;
		f[2][2] = temp20;
		temp00 = l[0][0];
		temp10 = l[1][0];
		l[0][0] = l[2][0];
		l[1][0] = l[2][1];
		l[2][0] = l[2][2];
		l[2][1] = l[1][2];
		l[2][2] = l[0][2];
		l[1][2] = l[0][1];
		l[0][2] = temp00;
		l[0][1] = temp10;
		System.out.println("");
	}

	void rP() {
		String temp00 = u[0][2];
		String temp10 = u[1][2];
		String temp20 = u[2][2];
		u[0][2] = f[0][2];
		u[1][2] = f[1][2];
		u[2][2] = f[2][2];
		f[0][2] = d[0][2];
		f[1][2] = d[2][2];
		f[2][2] = d[2][2];
		d[0][2] = b[0][2];
		d[1][2] = b[1][2];
		d[2][2] = b[2][2];
		b[0][2] = temp00;
		b[1][2] = temp10;
		b[2][2] = temp20;
		temp00 = l[0][0];
		temp10 = l[1][0];
		l[0][0] = l[2][0];
		l[1][0] = l[2][1];
		l[2][0] = l[2][2];
		l[2][1] = l[1][2];
		l[2][2] = l[0][2];
		l[1][2] = l[0][1];
		l[0][2] = temp00;
		l[0][1] = temp10;
		System.out.println("");
	}

	// rotate whole clockwise
	void y() {
		String[][] temp = f;
		f = r;
		r = b;
		b = l;
		l = temp;
		String temp00 = u[0][0];
		String temp10 = u[1][0];
		u[0][0] = u[2][0];
		u[1][0] = u[2][1];
		u[2][0] = u[2][2];
		u[2][1] = u[1][2];
		u[2][2] = u[0][2];
		u[1][2] = u[0][1];
		u[0][2] = temp00;
		u[0][1] = temp10;
		temp00 = d[0][0];
		temp10 = d[1][0];
		d[0][0] = d[0][2];
		d[1][0] = d[0][1];
		d[0][2] = d[2][2];
		d[0][1] = d[1][2];
		d[2][2] = d[2][0];
		d[1][2] = d[2][1];
		d[2][0] = temp00;
		d[2][1] = temp10;
		System.out.println("");
	}

	// rotate whole anti-clockwise
	void yP() {
		String[][] temp = f;
		f = l;
		l = b;
		b = r;
		r = temp;
		String temp00 = u[0][0];
		String temp10 = u[1][0];
		u[0][0] = u[2][0];
		u[1][0] = u[2][1];
		u[2][0] = u[2][2];
		u[2][1] = u[1][2];
		u[2][2] = u[0][2];
		u[1][2] = u[0][1];
		u[0][2] = temp00;
		u[0][1] = temp10;
		temp00 = d[0][0];
		temp10 = d[1][0];
		d[0][0] = d[0][2];
		d[1][0] = d[0][1];
		d[0][2] = d[2][2];
		d[0][1] = d[1][2];
		d[2][2] = d[2][0];
		d[1][2] = d[2][1];
		d[2][0] = temp00;
		d[2][1] = temp10;
		System.out.println("");
	}

	void print() {
		for (String[] i : b) {
			System.out.println("");
			for (int k = 0; k < 6; k++) {
				System.out.print(" ");
			}
			for (String j : i) {
				System.out.print(" " + j);
			}
		}
		for (int i = 0; i < 3; i++) {
			System.out.println("");
			for (String j : l[i]) {
				System.out.print(" " + j);
			}
			for (String j : u[i]) {
				System.out.print(" " + j);
			}
			for (String j : r[i]) {
				System.out.print(" " + j);
			}
		}
		for (String[] i : f) {
			System.out.println("");
			for (int k = 0; k < 6; k++) {
				System.out.print(" ");
			}
			for (String j : i) {
				System.out.print(" " + j);
			}
		}
		for (String[] i : d) {
			System.out.println("");
			for (int k = 0; k < 6; k++) {
				System.out.print(" ");
			}
			for (String j : i) {
				System.out.print(" " + j);
			}
		}
	}

}

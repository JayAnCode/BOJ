package Gold.스도쿠;

import java.io.*;

public class Main {
	static int map[][] = new int[9][9];

	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			String s = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		go(0, 0);

		br.close();
	}

	public static void go(int row, int col) {
		if (col == 9) {
			go(row + 1, 0);
			return;
		}
		if (row == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}

		if (map[row][col] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (isFlag(row, col, i)) {
					map[row][col] = i;
					go(row, col + 1);
				}
			}
			map[row][col] = 0;

			return;
		}

		go(row, col + 1);
	}
	public static boolean isFlag(int row, int col, int num) {
		if(!rowCheck(col, num) || !colCheck(row, num) || !mapCheck(row, col, num)) {
			return false;
		}

		return true;
	}
	public static boolean rowCheck(int col, int num) {
		for(int i=0; i<9; i++) {
			if(map[i][col] == num) {
				return false;
			}
		}

		return true;
	}
	public static boolean colCheck(int row, int num) {
		for(int i=0; i<9; i++) {
			if(map[row][i] == num) {
				return false;
			}
		}

		return true;
	}
	public static boolean mapCheck(int row, int col, int num) {
		int r = (row/3)*3; int c = (col/3)*3;
		for(int i=r; i<r+3; i++) {
			for(int j=c; j<c+3; j++) {
				if(map[i][j] == num) {
					return false;
				}
			}
		}

		return true;
	}
}

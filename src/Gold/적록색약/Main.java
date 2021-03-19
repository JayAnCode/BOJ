package Gold.적록색약;

import java.io.*;
import java.util.*;

public class Main {
	static int N, rgbAns, rrbAns;
	static char map[][];
	static boolean visited[][];
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) map[i] = br.readLine().toCharArray();
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (!visited[i][j]) {
					rgbAns++;
					dfs(i, j, map[i][j]);
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 'G') map[i][j] = 'R';
			}
		}
		for(int i=0; i<N; i++) Arrays.fill(visited[i], false);
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (!visited[i][j]) {
					rrbAns++;
					dfs(i, j, map[i][j]);
				}
			}
		}
		System.out.println(rgbAns + " " + rrbAns);
		br.close();
	}
	public static void dfs(int row, int col, char color) {
		if (visited[row][col]) return;
		visited[row][col] = true;
		for (int i=0; i<4; i++) {
			int nRow = row + dy[i];
			int nCol = col + dx[i];
			if ((nRow >= 0 && nRow < N) && (nCol >= 0 && nCol < N)) {
				if (color == map[nRow][nCol]) dfs(nRow, nCol, color);
			}
		}
	}
}

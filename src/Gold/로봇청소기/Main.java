package Gold.로봇청소기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static int count = 0;
	static int map[][];
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {-1, 0, 1, 0};
	public class Pair {
		int x;
		int y;
		public void Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		clean(r, c, d);
		System.out.println(count);
		br.close();
	}
	public static void clean(int row, int col, int dir) {
		if (map[row][col] == 0) {
			map[row][col] = 2;
			count++;
		}

		boolean flag = false;
		int curDir = dir;
		for (int i = 0; i < 4; i++) {
			int nd = (dir+3) % 4;
			int ny = row + dy[nd];
			int nx = col + dx[nd];
			if ((ny>0 && ny<map.length) && (nx>0 && nx<map[0].length)) {
				if (map[ny][nx] == 0) {
					clean(ny, nx, nd);
					flag = true;
					break;
				}
			}
			dir = nd;
		}

		if (!flag) {
			int nd = (curDir+2) % 4;
			int ny = row + dy[nd];
			int nx = col + dx[nd];
			if ((ny>0 && ny<map.length) && (nx>0 && nx<map[0].length)) {
				if (map[ny][nx] != 1) {
					clean(ny, nx, curDir);
				}
			}
		}
	}
}

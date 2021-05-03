package Gold.치즈;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, ans, time;
	static boolean flag;
	static int map[][];
	static boolean check[][];
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static class Pair {
		int row;
		int col;
		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		flag = false; time = 0; ans = 0;
		while(true) {
			check = new boolean[n][m];
			go(0, 0, 0, 0);

			if(flag) break;

			time++;
		}

		System.out.println(time);
		System.out.println(ans);
		br.close();
	}
	public static void go(int row, int col, int count, int cheeze) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(row, col));
		check[row][col] = true;

		while(!q.isEmpty()) {
			Pair p = q.poll();
			count++;

			for(int i=0; i<4; i++ ) {
				int nx = p.col + dx[i];
				int ny = p.row + dy[i];

				if((nx>=0 && nx<m) && (ny>=0 && ny<n)) {
					if(map[ny][nx] == 0 && !check[ny][nx]) {
						q.offer(new Pair(ny, nx));
						check[ny][nx] = true;
					}
					if(map[ny][nx] == 1 && !check[ny][nx]) {
						map[ny][nx] = 0;
						check[ny][nx] = true;
						cheeze++;
					}
				}
			}
		}

		if(count == n*m) flag = true;
		else ans = cheeze;
	}
}

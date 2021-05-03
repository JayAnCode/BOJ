package Silver.그림;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, max, ans;
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

		ans = 0;
		max = 0;
		check = new boolean[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!check[i][j] && map[i][j] == 1) {
					bfs(i, j, 1);
					ans++;
				}
			}
		}

		System.out.println(ans);
		System.out.println(max);
		br.close();
	}

	public static void bfs(int row, int col, int count) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(row, col));
		check[row][col] = true;

		while(!q.isEmpty()) {
			Pair p = q.poll();
			for(int i=0; i<4; i++) {
				int nx = p.col + dx[i];
				int ny = p.row + dy[i];

				if((nx>=0 && nx<m) && (ny>=0 && ny<n)) {
					if(!check[ny][nx] && map[ny][nx] == 1) {
						q.offer(new Pair(ny, nx));
						check[ny][nx] = true;
						count++;
					}
				}
			}
		}

		if(max < count) max = count;
	}
}

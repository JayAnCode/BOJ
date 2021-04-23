package Silver.데스_나이트;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, startR, startC, endR, endC, ans;
	static int map[][];
	static boolean check[][];
	static int dx[] = {-1, 1, -2, 2, -1, 1};
	static int dy[] = {-2, -2, 0, 0, 2, 2};
	static class Pair {
		int row;
		int col;
		int count;
		public Pair(int row, int col, int count) {
			this.row = row;
			this.col = col;
			this.count = count;
		}
	}
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		check = new boolean[N][N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		startR = Integer.parseInt(st.nextToken());
		startC = Integer.parseInt(st.nextToken());
		endR = Integer.parseInt(st.nextToken());
		endC = Integer.parseInt(st.nextToken());

		ans = bfs(startR, startC, 0);

		System.out.println(ans);
		br.close();
	}
	public static int bfs(int row, int col, int count) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(row, col, count));
		check[row][col] = true;

		while(!q.isEmpty()) {
			Pair p = q.poll();

			if((p.row == endR) && (p.col == endC)) return p.count;

			for(int i=0; i<6; i++) {
				int nx = p.col + dx[i];
				int ny = p.row + dy[i];

				if((nx>=0 && nx<N) && (ny>=0 && ny<N)) {
					if(!check[ny][nx]) {
						q.offer(new Pair(ny, nx, p.count+1));
						check[ny][nx] = true;
					}
				}
			}
		}

		return -1;
	}
}

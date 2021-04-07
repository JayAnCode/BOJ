package Gold.인구_이동;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, L, R, sum, avg;
	static int map[][];
	static boolean check[][];
	static int dx[] = {0, 0, -1, 1};
	static int dy[] = {-1, 1, 0, 0};
	static LinkedList<Pair> list;

	public static class Pair {
		int row;
		int col;
		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = 0;
		boolean flag = true;
		while(flag) {
			check = new boolean[N][N];
			flag = false;

			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!check[i][j]) {
						list = new LinkedList<>();
						sum = 0;
						bfs(i, j);
						if(list.size()>1) {
							avg = sum/list.size();
							for(Pair rc : list) map[rc.row][rc.col] = avg;
							flag = true;
						}
					}
				}
			}

			if(flag) ans++;
		}

		System.out.println(ans);
		br.close();
	}
	public static void bfs(int row, int col) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(row, col));
		check[row][col] = true;
		sum += map[row][col];
		list.add(new Pair(row, col));

		while(!q.isEmpty()) {
			Pair p = q.poll();

			for(int i=0; i<4; i++) {
				int nx = p.col + dx[i];
				int ny = p.row + dy[i];

				if((nx>=0 && nx<N) && ny>=0 && ny<N) {
					if(!check[ny][nx] &&
							((Math.abs(map[ny][nx]-map[p.row][p.col])>=L) &&
									(Math.abs(map[ny][nx]-map[p.row][p.col])<=R))) {
						q.offer(new Pair(ny, nx));
						check[ny][nx] = true;
						sum += map[ny][nx];
						list.add(new Pair(ny, nx));
					}
				}
			}
		}
	}
}

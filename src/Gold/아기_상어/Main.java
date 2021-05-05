package Gold.아기_상어;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, ans;
	static int shark_size, shark_count;
	static boolean flag;
	static Shark shark;
	static int map[][];
	static boolean visited[][];
	static int dx[] = {0, -1, 1, 0};
	static int dy[] = {-1, 0, 0, 1};
	static class Shark {
		int row;
		int col;
		int dist;
		public Shark(int row, int col, int dist) {
			this.row = row;
			this.col = col;
			this.dist = dist;
		}
	}

	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if(map[i][j] == 9) shark = new Shark(i, j, 0);
			}
		}

		ans = 0; shark_size = 2; shark_count = 0;
		while(true) {
			flag = false;
			visited = new boolean[N][N];
			bfs();

			if(!flag) break;

			check();
		}

		System.out.println(ans);
		br.close();
	}

	public static void bfs() {
		Queue<Shark> q = new LinkedList<>();
		q.offer(new Shark(shark.row, shark.col, 0));
		map[shark.row][shark.col] = 0;
		visited[shark.row][shark.col] = true;

		while(!q.isEmpty()) {
			Shark sh = q.poll();
			for(int i=0; i<4; i++) {
				int nx = sh.col + dx[i];
				int ny = sh.row + dy[i];

				if((nx>=0 && nx<N) && (ny>=0 && ny<N) && !visited[ny][nx]) {
					if(map[ny][nx] != 0 && map[ny][nx] < shark_size) {
						ans += (sh.dist+1);
						map[ny][nx] = 0;
						shark = new Shark(ny, nx, 0);
						flag = true;
						break;
					}
					else if(map[ny][nx] == 0 || map[ny][nx] == shark_size) {
						q.offer(new Shark(ny, nx, sh.dist+1));
						visited[ny][nx] = true;
					}
				}
			}
			if(flag) break;
		}
	}

	public static void check() {
		shark_count += 1;

		if(shark_count == shark_size) {
			shark_size += 1;
			shark_count = 0;
		}
	}
}

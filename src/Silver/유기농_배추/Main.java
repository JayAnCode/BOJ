package Silver.유기농_배추;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static int M, N, K, count;
	static int map[][];
	static boolean visited[][];
	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, -1, 1};

	public static class Pair {
		int col;
		int row;
		public Pair(int col, int row) {
			this.col = col;
			this.row = row;
		}
	}
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			count = 0;
			map = new int[N][M];
			visited = new boolean[N][M];
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]==1 && !visited[i][j]) {
						bfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
		br.close();
	}
	public static void bfs(int col, int row) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(col, row));
		visited[col][row] = true;
		while (!q.isEmpty()) {
			Pair p = q.poll();
			for (int i=0; i<4; i++) {
				int nx = p.row + dx[i];
				int ny = p.col + dy[i];
				if((ny>=0 && ny<map.length) && (nx>=0 && nx<map[0].length)){
					if (!visited[ny][nx] && map[ny][nx]==1) {
						q.offer(new Pair(ny, nx));
						visited[ny][nx] = true;
					}
				}
			}
		}
	}
}

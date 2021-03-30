package Silver.미로_탐색;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static int N, M;
	static int map[][];
	static int count[][];
	static int dx[] = {0, 0, -1, 1};
	static int dy[] = {1, -1, 0, 0};
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
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		count = new int[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		bfs(0, 0);
		System.out.println(count[N-1][M-1]);
		br.close();
	}
	static void bfs(int col, int row) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(col, row));
		count[col][row] = 1;
		while (!q.isEmpty()) {
			Pair p = q.poll();
			for (int i=0; i<4; i++) {
				int nx = p.row + dx[i];
				int ny = p.col + dy[i];
				if((ny>=0 && ny<map.length) && (nx>=0 && nx<map[0].length)) {
					if (count[ny][nx]==0 && map[ny][nx]==1) {
						q.offer(new Pair(ny, nx));
						count[ny][nx] = count[p.col][p.row]+1;
					}
				}
			}
		}
	}
}

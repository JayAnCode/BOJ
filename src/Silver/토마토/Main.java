package Silver.토마토;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static int M, N, count;
	static int box[][];
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
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		for(int i=0; i<N; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		bfs();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(box[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				count = Math.max(count, box[i][j]);
			}
		}
		System.out.println(count-1);
	}
	public static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(box[i][j] == 1) q.offer(new Pair(i, j));
			}
		}
		while(!q.isEmpty()) {
			Pair p = q.poll();
			for (int i=0; i<4; i++) {
				int nx = p.row + dx[i];
				int ny = p.col + dy[i];
				if((ny>=0 && ny<box.length) && (nx>=0 && nx<box[0].length)) {
					if (box[ny][nx] == 0) {
						box[ny][nx] = box[p.col][p.row] + 1;
						q.offer(new Pair(ny, nx));
					}
				}
			}
		}
	}
}

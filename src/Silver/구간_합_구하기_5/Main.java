package Silver.구간_합_구하기_5;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int map[][], dp[][];
	static Queue<Point> q;
	static StringBuilder sb = new StringBuilder();
	static class Point {
		int sX; int sY;
		int eX; int eY;
		public Point(int sX, int sY, int eX, int eY) {
			this.sX = sX; this.sY = sY;
			this.eX = eX; this.eY = eY;
		}
	}
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N+1][N+1];
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		q = new LinkedList<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			q.offer(new Point(sx, sy, ex, ey));
		}

		dp = new int[N+1][N+1];
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + map[i][j];
			}
		}

		go();

		System.out.print(sb.toString());
		br.close();
	}

	public static void go() {
		while(!q.isEmpty()) {
			Point p = q.poll();
			int sum = 0;

			sum = dp[p.eX][p.eY] - (dp[p.eX][p.sY-1] + dp[p.sX-1][p.eY] - dp[p.sX-1][p.sY-1]);
			sb.append(sum + "\n");
		}
	}
}

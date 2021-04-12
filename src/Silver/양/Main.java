package Silver.양;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C, W, S;
	static char map[][];
	static boolean check[][];
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	public static class Loc {
		int r; int c;
		public Loc(int r, int c) {
			this.r = r; this.c = c;
		}
	}
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		check = new boolean[R][C];

		for(int i=0; i<R; i++) map[i] = br.readLine().toCharArray();

		W = 0; S = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(!check[i][j] && map[i][j] != '#') {
					bfs(i, j);
				}
			}
		}

		System.out.println(S + " " + W);
		br.close();
	}
	public static void bfs(int row, int col) {
		Queue<Loc> q = new LinkedList<>();
		q.offer(new Loc(row, col));
		check[row][col] = true;

		int countW = 0; int countS = 0;
		if(map[row][col] == 'o') countS++;
		else if(map[row][col] == 'v') countW++;

		while(!q.isEmpty()) {
			Loc l = q.poll();

			for(int i=0; i<4; i++) {
				int nx = l.c + dx[i];
				int ny = l.r + dy[i];

				if((nx>=0 && nx<C) && ny>=0 && ny<R) {
					if(!check[ny][nx] && map[ny][nx] != '#') {
						if(map[ny][nx] == 'o') countS++;
						else if(map[ny][nx] == 'v') countW++;

						q.offer(new Loc(ny, nx));
						check[ny][nx] = true;
					}
				}
			}
		}

		if(countS > countW) S += countS;
		else W += countW;
	}
}

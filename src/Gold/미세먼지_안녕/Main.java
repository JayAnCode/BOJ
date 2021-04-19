package Gold.미세먼지_안녕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C, T, top, bottom, ans;
	static int map[][];
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static Queue<Dust> q;
	static class Dust {
		int row;
		int col;
		int amount;
		public Dust(int row, int col, int amount) {
			this.row = row;
			this.col = col;
			this.amount = amount;
		}
	}
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		top = 0;

		map = new int[R+1][C+1];
		for(int i=1; i<R+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<C+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					if(top == 0) top = i;
					else bottom = i;
				}

			}
		}

		while(T-->0) {
			step1();
			step2();
			calc();
		}

		System.out.println(ans);
		br.close();
	}
	public static void step1() {
		q = new LinkedList<>();
		for(int i=1; i<R+1; i++) {
			for(int j=1; j<C+1; j++) {
				if(map[i][j] > 0) q.offer(new Dust(i, j, map[i][j]));
			}
		}

		while(!q.isEmpty()) {
			Dust d = q.poll();
			if(d.amount < 5) continue;
			for(int i=0; i<4; i++) {
				int nx = d.col + dx[i];
				int ny = d.row + dy[i];
				if((nx>0 && nx<=C) && (ny>0 && ny<=R)) {
					if(map[ny][nx] == -1) continue;
					map[ny][nx] += d.amount/5;
					map[d.row][d.col] -= d.amount/5;
				}
			}
		}
	}
	public static void step2() {
		topClean();
		bottomClean();
	}
	public static void topClean() {
		// 아래로 당기기
		for(int i=top-1; i>1; i--) map[i][1] = map[i-1][1];
		// 왼쪽으로 당기기
		for(int i=1; i<C ; i++) map[1][i] = map[1][i+1];
		// 위로 당기기
		for(int i=1; i<top; i++) map[i][C] = map[i+1][C];
		// 오른쪽으로 당기기
		for(int i=C; i>2; i--) map[top][i] = map[top][i-1];

		map[top][2] = 0;
	}
	public static void bottomClean() {
		// 위로 당기기
		for (int i=bottom+1; i<R; i++)
			map[i][1] = map[i+1][1];
		// 왼쪽으로 당기기
		for (int i=1; i<C; i++)
			map[R][i] = map[R][i+1];
		// 아래로 당기기
		for (int i=R; i>bottom; i--)
			map[i][C] = map[i-1][C];
		// 오른쪽으로 당기기
		for (int i=C; i>2; i--)
			map[bottom][i] = map[bottom][i-1];

		map[bottom][2] = 0;
	}
	public static void calc() {
		ans = 0;
		for(int i=1; i<R+1; i++) {
			for(int j=1; j<C+1; j++) {
				if(map[i][j] == -1) continue;
				ans += map[i][j];
			}
		}
	}
}

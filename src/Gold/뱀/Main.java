package Gold.뱀;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K, L, dir, time;
	static boolean snake[][];
	static int map[][];
	static int dc[] = {1, 0, -1, 0};
	static int dr[] = {0, 1, 0, -1};
	static Queue<Move> move = new LinkedList<>();
	static LinkedList<Snake> snakes = new LinkedList<>();

	static class Move {
		int x;
		char c;
		public Move(int x, char c) {
			this.x = x;
			this.c = c;
		}
	}
	static class Snake {
		int r;
		int c;
		public Snake(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		map = new int[N+1][N+1];
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
		}

		L = Integer.parseInt(br.readLine());
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			move.offer(new Move(x, c));
		}

		snake = new boolean[N+1][N+1];
		snake[1][1] = true;
		snakes.add(0, new Snake(1, 1));

		dir = 0; time = 0;
		Move m = move.poll();
		while(true) {
			if(!go()) break;

			time++;

			if(time == m.x) {
				if(m.c == 'D') dir = (dir+1)%4;
				else dir = (dir+3)%4;

				if(!move.isEmpty()) m = move.poll();
			}
		}

		System.out.println(time+1);
		br.close();
	}

	public static boolean go() {
		int nr = snakes.get(0).r + dr[dir];
		int nc = snakes.get(0).c  + dc[dir];

		if((nr<=0 || nr>N) || (nc<=0 || nc>N)) {
			return false;
		}	//벽에 부딪히는 경우
		if(snake[nr][nc]) {
			return false;
		}	//자신의 몸에 부딪히는 경우

		snakes.add(0, new Snake(nr, nc));
		snake[nr][nc] = true;

		if(map[nr][nc] != 1) {
			Snake s = snakes.remove(snakes.size()-1);
			snake[s.r][s.c] = false;
		}	//사과를 먹지 않은 경우
		else {
			map[nr][nc] = 0;
		}

		return true;
	}
}

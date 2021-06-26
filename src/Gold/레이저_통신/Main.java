package Gold.레이저_통신;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int W, H, min;
	static boolean flag;
	static Pair start, end;
	static char map[][];
	static int check[][];
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};

	static class Pair {
		int row;
		int col;
		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}	// 좌표

	static class Move {
		Pair p;
		int dir;
		int count;
		public Move(Pair p, int dir, int count) {
			this.p = p;
			this.dir = dir;
			this.count = count;
		}
	}	// 현재 레이저의 위치와 진행 방향, 회전 수

	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new char[H][W];
		for(int i=0; i<H; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0; j<W; j++) {
				if(map[i][j] == 'C') {
					if(!flag) {
						start = new Pair(i, j);	// 시작 좌표
						flag = true;
					}
					else end = new Pair(i, j);	// 끝 좌표
				}
			}
		}

		min = Integer.MAX_VALUE;
		check = new int[H][W];	// 해당 좌표가 몇 번의 회전을 통해 왔는지 확인
		bfs();

		System.out.println(min);
		br.close();
	}

	public static void bfs() {
		Queue<Move> q = new LinkedList<>();
		q.offer(new Move(start, -1, 0));
		check[start.row][start.col] = 0;

		while(!q.isEmpty()) {
			Move m = q.poll();

			if(m.p.row == end.row && m.p.col == end.col) {
				min = Math.min(min, m.count);
			}	// 종료 지점 도착 시 최소 회전 수 계산

			for(int i=0; i<4; i++) {
				int nx = m.p.col + dx[i];
				int ny = m.p.row + dy[i];

				if((nx<0 || nx>=W) || (ny<0 || ny>=H)) continue;

				if(map[ny][nx] != '*') {
					int count = m.count;	// 현재까지 회전 수

					if(m.dir != -1 && m.dir != i) {
						count += 1;
					}	// 방향이 바뀌면 회전 수 + 1

					if(check[ny][nx] >= count || check[ny][nx] == 0) {
						check[ny][nx] = count;
						q.offer(new Move(new Pair(ny, nx), i, count));
					}	// 다음 위치의 회전 수 보다 지금의 회전 수가 더 작거나 다음 위치가 방문한 적이 없는 곳이면 다음 위치의 회전 수를 현재 회전 수로 초기화
				}
			}
		}
	}
}


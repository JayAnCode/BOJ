package Gold.연구소;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans;
	static int map[][];
	static int copyMap[][];
	static boolean check[][];
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};

	static class Pair {
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
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = Integer.MIN_VALUE;
		go(0);

		System.out.println(ans);
		br.close();
	}
	public static void go(int count) {
		if(count == 3) {	// 벽이 3개 일 때 최대 영역의 크기 찾기 시작
			copy();	// 벽이 3개 일 때마다 영역의 크기를 계산하기 위해 map을 복사
			check = new boolean[N][M];

			for(int i=0; i<N; i++) {
				for (int j = 0; j < M; j++) {
					if(copyMap[i][j] == 2 && !check[i][j]) {
						bfs(i, j);
					}
				}
			}

			int cur = calc();	// 영역의 크기 계산

			ans = Math.max(ans, cur);
			return;
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;	// 벽을 새로 세움
					go(count+1);
					map[i][j] = 0;
				}
			}
		}
	}

	public static void bfs(int row, int col) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(row, col));
		check[row][col] = true;

		while(!q.isEmpty()) {
			Pair p = q.poll();

			for(int i=0; i<4; i++) {
				int nx = p.col + dx[i];
				int ny = p.row + dy[i];

				if((nx>=0 && nx<M) && (ny>=0 && ny<N)) {
					if(copyMap[ny][nx] == 0) {
						copyMap[ny][nx] = 2;
						q.offer(new Pair(ny, nx));
						check[ny][nx] = true;
					}
				}
			}
		}	// 바이러스가 퍼지는 과정
	}

	public static void copy() {
		copyMap = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}

	public static int calc() {
		int count = 0;
		for(int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if(copyMap[i][j] == 0) count++;
			}
		}	// 안전 영역 크기 계산
		return count;
	}
}

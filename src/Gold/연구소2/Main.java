package Gold.연구소2;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, min, max;
	static int map[][];
	static int copyMap[][];
	static boolean visited[][];
	static boolean virusCheck[];
	static ArrayList<Virus> virusList = new ArrayList<>();
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static class Virus {
		int row;
		int col;
		int count;
		public Virus(int row, int col, int count) {
			this.row = row;
			this.col = col;
			this.count = count;
		}
	}

	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());

			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if(map[i][j] == 1) map[i][j] = -1;	// 벽은 -1로 초기화

				if(map[i][j] == 2) {
					virusList.add(new Virus(i, j, 0));
					map[i][j] = 0;
				}	// 바이러스의 위치 기록 후 빈칸으로 초기화
			}
		}

		virusCheck = new boolean[virusList.size()];	// 바이러스를 놓을 위치를 정하기 위한 배열

		min = Integer.MAX_VALUE;
		dfs(0, 0);

		if(min == Integer.MAX_VALUE) System.out.println("-1");	// 바이러스가 모두 퍼질 수 없는 경우
		else System.out.println(min);	// 바이러스가 모두 퍼진 경우
		br.close();
	}

	public static void dfs(int index, int count) {
		if(count == M) {
			copyMap = new int[N][N];
			copy();	// 별도의 계산을 위해 기존의 map을 copy

			for(int i=0; i<virusCheck.length; i++) {
				if(virusCheck[i]) {
					visited = new boolean[N][N];
					bfs(virusList.get(i).row, virusList.get(i).col);
				}
			}	// 바이러스가 퍼지는 시간 계산

			max = 0;
			if(calc()) {
				min = Math.min(min, max);
			}	// 위치별 최소 시간 계산
		}

		for(int i=index; i<virusCheck.length; i++) {
			if(!virusCheck[i]) {
				virusCheck[i] = true;
				map[virusList.get(i).row][virusList.get(i).col] = -2;

				dfs(i+1, count+1);

				map[virusList.get(i).row][virusList.get(i).col] = 0;
				virusCheck[i] = false;
			}	// 바이러스의 위치를 정함
		}
	}

	public static void bfs(int row, int col) {
		Queue<Virus> q = new LinkedList<>();
		q.offer(new Virus(row, col, 0));
		visited[row][col] = true;

		while(!q.isEmpty()) {
			Virus v = q.poll();

			for(int i=0; i<4; i++) {
				int nx = v.col + dx[i];
				int ny = v.row + dy[i];

				if((nx<0 || nx>=N) || (ny<0 || ny>=N)) continue;
				if(copyMap[ny][nx] >= 0 && !visited[ny][nx]) {
					q.offer(new Virus(ny, nx, v.count+1));
					visited[ny][nx] = true;
					if(copyMap[ny][nx] > v.count+1 || copyMap[ny][nx] == 0) {
						copyMap[ny][nx] = v.count+1;
					}	// 바이러스가 생길 위치가 빈칸이거나 이전 시간보다 작으면 새로운 시간으로 초기화
				}
			}
		}
	}

	public static void copy() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}

	public static boolean calc() {
		max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(copyMap[i][j] == 0) return false;	// 빈칸이 있으면 바이러스가 모두 퍼지지 않은 경우

				if(copyMap[i][j] < 0) continue;

				max = Math.max(max, copyMap[i][j]);
			}
		}	// 바이러스가 퍼진 시간 중 최장 시간 계산

		return true;
	}
}

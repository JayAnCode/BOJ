package Gold.성곽;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, roomCount, count, roomMax1, roomMax2;
	static int map[][];
	static boolean visited[][];
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, -1, 0, 1};
	static class Room {
		int row;
		int col;
		public Room(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[m][n];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[m][n];
		roomCount = 0; roomMax1 = 1;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					count = 0;
					bfs(i, j);
					roomMax1 = Math.max(roomMax1, count);
					roomCount++;
				}
			}
		}


		roomMax2 = roomMax1;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				int bit = map[i][j];
				for(int k=0; k<4; k++) {
					if ((bit & 1) == 1) {
						map[i][j] -= Math.pow(2, k);
						count = 0;
						visited = new boolean[m][n];
						bfs(i, j);
						roomMax2 = Math.max(roomMax2, count);
						map[i][j] += Math.pow(2, k);
					}
					bit = bit >> 1;
				}
			}
		}

		System.out.println(roomCount);
		System.out.println(roomMax1);
		System.out.println(roomMax2);
		br.close();
	}
	public static void bfs(int row, int col) {
		Queue<Room> q = new LinkedList<>();
		q.offer(new Room(row, col));
		visited[row][col] = true;

		while(!q.isEmpty()) {
			Room r = q.poll();
			count++;

			int bit = map[r.row][r.col];
			for(int i=0; i<4; i++) {
				int nx = r.col + dx[i];
				int ny = r.row + dy[i];

				if((bit & 1) == 0) {
					if((nx>=0 && nx<n) && (ny>=0 && ny<m)) {
						if(!visited[ny][nx]) {
							q.offer(new Room(ny, nx));
							visited[ny][nx] = true;
						}
					}
				}

				bit = bit >> 1;
			}
		}
	}
}

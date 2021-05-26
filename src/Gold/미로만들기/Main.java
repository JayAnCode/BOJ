package Gold.미로만들기;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n, max, min;
	static int map[][];
	static int changed[][];
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};

	static class Room {
		int row;
		int col;
		int count;
		public Room(int row, int col, int count) {
			this.row = row;
			this.col = col;
			this.count = count;
		}
	}

	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		int max = 0;
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j] = s.charAt(j)-'0';
				if(map[i][j] == 0) max++;
			}
		}

		changed = new int[n][n];
		for(int i=0; i<n; i++) Arrays.fill(changed[i], max);		// 모든 방을 바꿀 경우 변경 횟수를 초기화
		bfs(0, 0);

		System.out.println(changed[n-1][n-1]);
		br.close();
	}

	public static void bfs(int row, int col) {
		Queue<Room> q = new LinkedList<>();
		q.offer(new Room(row, col, 0));
		changed[row][col] = 0;

		while(!q.isEmpty()) {
			Room r =q.poll();
			if(r.row == n-1 && r.col == n-1) continue;		// 마지막 방에 도착하면 이동X

			for(int i=0; i<4; i++) {
				int nx = r.col + dx[i];
				int ny = r.row + dy[i];

				if((nx<0 || nx>=n) || (ny<0 || ny>=n)) continue;		// 범위를 벗어나면 이동X

				if(map[ny][nx] == 0) {
					if(changed[ny][nx] > r.count + 1) {
						q.offer(new Room(ny, nx, r.count+1));
						changed[ny][nx] = r.count + 1;
					}		// 다음 방문할 방이 바뀐 횟수보다 바꿔온 횟수+1이 적을 때
				}		// 다음 방문할 방이 검은 방일 때
				else if(map[ny][nx] == 1) {
					if(changed[ny][nx] > r.count) {
						q.offer(new Room(ny, nx, r.count));
						changed[ny][nx] = r.count;
					}		// 다음 방문할 방이 바뀐 횟수보다 바꿔온 횟수가 적을 때
				}		// 다음 방문할 방이 흰 방일 때
			}
		}
	}
}

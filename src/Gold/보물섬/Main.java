package Gold.보물섬;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C, max;
	static char map[][];
	static boolean visited[][];
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};

	static class Node {
		int r;
		int c;
		int dist;
		public Node(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}

	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		max = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == 'L') {
					visited = new boolean[R][C];
					bfs(i, j);
				}
			}
		}

		System.out.println(max);
		br.close();
	}

	public static void bfs(int row, int col) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(row, col, 0));
		visited[row][col] = true;

		while(!q.isEmpty()) {
			Node n = q.poll();

			if(max < n.dist) max = n.dist;

			for(int i=0; i<4; i++) {
				int nx = n.c+ dx[i];
				int ny = n.r + dy[i];

				if((nx>=0 && nx<C) && (ny>=0 && ny<R)) {
					if(!visited[ny][nx] && map[ny][nx] == 'L') {
						q.offer(new Node(ny, nx, n.dist+1));
						visited[ny][nx] = true;
					}
				}
			}
		}
	}
}

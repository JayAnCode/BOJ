package Silver.영역_구하기;

import java.io.*;
import java.util.*;

public class Main {
	static int M, N, K;
	static int map[][];
	static boolean check[][];
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	public static class Loc {
		int row;
		int col;
		public Loc(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		check = new boolean[M][N];
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			for(int i=startY; i<endY; i++) {
				for(int j=startX; j<endX; j++) map[i][j] = 1;
			}
		}

		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] != 1 && !check[i][j]) list.add(bfs(i, j));
			}
		}

		Collections.sort(list);

		System.out.println(list.size());
		for(int i=0; i<list.size()-1; i++) System.out.print(list.get(i) + " ");
		System.out.println(list.get(list.size()-1));
		br.close();
	}
	public static int bfs(int row, int col) {
		Queue<Loc> q = new LinkedList<>();
		q.offer(new Loc(row, col));
		check[row][col] = true;
		int count = 1;

		while(!q.isEmpty()) {
			Loc l = q.poll();

			for(int i=0; i<4; i++) {
				int nx = l.col + dx[i];
				int ny = l.row + dy[i];

				if((nx>=0 && nx<N) && (ny>=0 && ny<M)) {
					if(map[ny][nx] != 1 && !check[ny][nx]) {
						q.offer(new Loc(ny, nx));
						check[ny][nx] = true;
						count++;
					}
				}
			}
		}

		return count;
	}
}

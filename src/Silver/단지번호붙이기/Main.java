package Silver.단지번호붙이기;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int dx[] = {0, 0, -1, 1};
	static int dy[] = {-1, 1, 0, 0};
	static int N, count;
	static int map[][];
	static boolean visited[][];
	static ArrayList<Integer> list;
	public static class Pair {
		int col;
		int row;
		public Pair(int col, int row) {
			this.col = col;
			this.row = row;
		}
	}
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j] && map[i][j]==1) {
					bfs(i, j);
					list.add(count);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int i=0; i<list.size(); i++) System.out.println(list.get(i));
		br.close();
	}
	static void bfs(int col, int row) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(col, row));
		visited[col][row] = true;
		count = 1;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			for(int i=0; i<4; i++) {
				int ny = p.col + dy[i];
				int nx = p.row + dx[i];
				if((ny>=0 && ny<N) && (nx>=0 && nx<N)) {
					if(!visited[ny][nx] && map[ny][nx]==1) {
						q.offer(new Pair(ny, nx));
						visited[ny][nx] = true;
						count++;
					}
				}
			}
		}
	}
}

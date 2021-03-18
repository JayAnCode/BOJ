package Gold.Puyo_Puyo;

import java.io.*;
import java.util.*;

public class Main {
	static char map[][] = new char[12][6];
	static int visited[][] = new int[12][6];
	static char c[] = new char[6];
	static int[] dx = new int[] { 0, 0, -1, 1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static int ans = 0;
	static ArrayList<Pair> list = new ArrayList<>();
	public static class Pair {
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<12; i++) map[i] = br.readLine().toCharArray();
		while(true) {
			boolean flag = false;
			for(int i=0; i<12; i++) Arrays.fill(visited[i], 0);
			for(int i=0; i<12; i++) {
				for(int j=0; j<6; j++) {
					if(visited[i][j] == 0 && map[i][j] != '.') bfs(j, i);
					if(list.size()>=4) {
						flag = true;
						for(Pair p : list) map[p.y][p.x] = '.';
					}
					list.clear();
				}
			}
			if(flag) {
				for (int i=0; i<6; i++) {
					for (int j=11; j>0; j--) {
						if(map[j][i] == '.') {
							for(int k=j-1; k>=0; k--) {
								if(map[k][i] != '.') {
									map[j][i] = map[k][i];
									map[k][i] = '.';
									break;
								}
							}
						}
					}
				}
				ans++;
			}
			else break;
		}
		System.out.println(ans);
		br.close();
	}
	static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y));
		list.add(new Pair(x, y));
		visited[y][x] = 1;
		while (!q.isEmpty()) {
			Pair p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if((ny >= 0 && ny < 12) && (nx >= 0 && nx < 6)){
					if (visited[ny][nx]==0 && map[ny][nx]==map[y][x]) {
						q.offer(new Pair(nx, ny));
						list.add(new Pair(nx, ny));
						visited[ny][nx] = 1;
					}
				}
			}
		}
	}
}

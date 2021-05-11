package Gold.드래곤_커브;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N, x, y, d, g, ans;
	static int dx[] = {1, 0 ,-1, 0};
	static int dy[] = {0, -1, 0, 1};
	static boolean visited[][] = new boolean[101][101];
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		while(N-- > 0) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());

			go(x, y, d, g);
		}

		ans = calc();
		System.out.println(ans);
		br.close();
	}

	public static void go(int x, int y, int d, int g) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(d);
		for(int i=0; i<g; i++) {
			int size = list.size();
			for(int j=size-1; j>=0; j--) {
				list.add((list.get(j)+1)%4);
			}
		}

		int nx = x; int ny = y;
		visited[ny][nx] = true;
		for(int i : list) {
			nx = nx + dx[i];
			ny = ny + dy[i];
			visited[ny][nx] = true;
		}
	}

	public static int calc() {
		int count = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(visited[i][j] && visited[i+1][j] && visited[i][j+1] && visited[i+1][j+1]) {
					count++;
				}
			}
		}

		return count;
	}
}

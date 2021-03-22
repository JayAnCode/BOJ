package Silver.연결_요소의_개수;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int count = 0;
	static int map[][];
	static boolean point[];
	public static class Pair {
		int u;
		int v;
		public Pair(int u, int v) {
			this.u = u;
			this.v = v;
		}
	}
	public static void main(String arg[]) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		point = new boolean[N+1];
		map = new int[N+1][N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[u][v] = map[v][u] = 1;
		}
		for(int i=1; i<=N; i++) {
			if(point[i] == false) {
				dfs(i);
				count++;
			}
		}
		System.out.println(count);
		br.close();
	}
	public static void dfs(int u) {
		if(point[u] == true)
			return;
		else {
			point[u] = true;
			for(int i=1; i<=N; i++) {
				if(map[u][i] == 1) {
					dfs(i);
				}
			}
		}
	}
}

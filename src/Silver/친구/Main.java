package Silver.친구;

import java.io.*;

public class Main {
	static int N, count, ans;
	static char friends[][];
	static boolean visited[];

	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		friends = new char[N][N];
		for(int i=0; i<N; i++) {
			friends[i] = br.readLine().toCharArray();
		}

		ans = 0;
		for(int i=0; i<N; i++) {
			count = 0;
			visited = new boolean[N];
			dfs(i, 0);
			calc();

			ans = Math.max(ans, count-1);
		}

		System.out.println(ans);
		br.close();
	}

	public static void dfs(int x, int depth) {
		visited[x] = true;

		if(depth == 2) {
			return;
		}

		for(int i=0; i<N; i++) {
			if(friends[x][i] == 'Y') {
				dfs(i, depth+1);
			}
		}
	}
	public static void calc() {
		for(int i=0; i<N; i++) {
			if(visited[i]) count++;
		}
	}
}

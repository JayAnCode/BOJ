package Silver.음식물_피하기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, cur, ans;
	static int map[][];
	static boolean check[][];
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		check = new boolean[N][M];
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r-1][c-1] = 1;
		}

		ans = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1 && !check[i][j]) {
					cur = dfs(i, j, 1);
					ans = Math.max(ans, cur);
				}
			}
		}

		System.out.println(ans);
		br.close();
	}
	public static int dfs(int row, int col, int sum) {
		check[row][col] = true;

		for(int i=0; i<4; i++) {
			int nx = col + dx[i];
			int ny = row + dy[i];
			if((nx>=0 && nx<M) && (ny>=0 && ny<N)) {
				if(!check[ny][nx] && map[ny][nx] == 1) {
					sum = dfs(ny, nx, sum+1);
				}
			}
		}

		return sum;
	}
}

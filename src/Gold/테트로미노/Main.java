package Gold.테트로미노;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans;
	static int map[][];
	static boolean check[][];
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};

	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		check = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				check[i][j] = true;
				go(i, j, 1, map[i][j]);
				except(i, j);
				check[i][j] = false;
			}
		}

		System.out.println(ans);
		br.close();
	}

	public static void go(int row, int col, int count, int sum) {
		if(count == 4) {
			ans = Math.max(ans, sum);
			return;
		}

		for(int i=0; i<4; i++) {
			int nx = col + dx[i];
			int ny = row + dy[i];

			if((nx>=0 && nx<M) && (ny>=0 && ny<N)) {
				if(!check[ny][nx]) {
					check[ny][nx] = true;
					go(ny, nx, count+1, sum+map[ny][nx]);
					check[ny][nx] = false;
				}
			}
		}
	}

	public static void except(int row, int col) {
		if((row>=0 && row<N-1) && (col>0 && col<M-1)) {
			ans = Math.max(ans, map[row][col] + map[row][col-1] + map[row][col+1] + map[row+1][col]);
		}
		if((row>0 && row<N) && (col>0 && col<M-1)) {
			ans = Math.max(ans, map[row][col] + map[row][col-1] + map[row][col+1] + map[row-1][col]);
		}
		if((row>0 && row<N-1) && (col>=0 && col<M-1)) {
			ans = Math.max(ans, map[row][col] + map[row+1][col] + map[row-1][col] + map[row][col+1]);
		}
		if((row>0 && row<N-1) && (col>0 && col<M)) {
			ans = Math.max(ans, map[row][col] + map[row+1][col] + map[row-1][col] + map[row][col-1]);
		}
	}
}

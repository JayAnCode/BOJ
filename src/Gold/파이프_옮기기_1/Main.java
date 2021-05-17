package Gold.파이프_옮기기_1;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int map[][] = new int[N+1][N+1];
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int dp[][][] = new int[N+1][N+1][3];	// 0: 가로, 1: 세로, 2: 대각선
		dp[1][2][0] = 1;	// (1,2)에 가로 방향의 파이프 끝이 있음
		for(int i=1; i<N+1; i++) {
			for(int j=3; j<N+1; j++) {
				if(map[i][j] != 1) {
					dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];		// 가로 방향으로 놓을 때
					dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];		// 세로 방향으로 놓을 때

					if(map[i-1][j] != 1 && map[i][j-1] != 1) {
						dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
					}		// 대각선 방향으로 놓을 때
				}
			}
		}

		System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
		br.close();
	}
}

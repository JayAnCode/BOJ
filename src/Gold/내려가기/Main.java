package Gold.내려가기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int move[] = {-1, 1};
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int map[][] = new int[N][3];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int dp[][][] = new int[N][3][2];
		dp[0][0][0] = dp[0][0][1] = map[0][0];
		dp[0][1][0] = dp[0][1][1] = map[0][1];
		dp[0][2][0] = dp[0][2][1] = map[0][2];
		for(int i=1; i<N; i++) {
			for(int j=0; j<3; j++) {
				dp[i][j][0] = dp[i-1][j][0]+map[i][j];
				dp[i][j][1] = dp[i-1][j][1]+map[i][j];
				for(int k=0; k<2; k++) {
					int prev = j + move[k];
					if(prev<0 || prev>=3) continue;
					dp[i][j][0] = Math.min(dp[i][j][0], dp[i-1][prev][0]+map[i][j]);
					dp[i][j][1] = Math.max(dp[i][j][1], dp[i-1][prev][1]+map[i][j]);
				}
			}
		}

		for(int i=0; i<3; i++) {
			min = Math.min(min, dp[N-1][i][0]);
			max = Math.max(max, dp[N-1][i][1]);
		}

		System.out.println(max + " " + min);
		br.close();
	}
}

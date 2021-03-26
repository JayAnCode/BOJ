package Silver.RGB거리;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int dp[][] = new int[N+1][3];

		StringTokenizer st;
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=2; i<N+1; i++) {
			for(int j=0; j<3; j++) {
				dp[i][j] += Math.min(dp[i-1][(j+2)%3], dp[i-1][(j+1)%3]);
			}
		}

		System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
		br.close();
	}
}

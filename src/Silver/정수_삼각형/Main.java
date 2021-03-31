package Silver.정수_삼각형;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int dp[][] = new int[n][n];
		int max = 0;
		dp[0][0] = Integer.parseInt(br.readLine());
		for(int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j <= i; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
				if(j == 0) dp[i][j] += dp[i-1][j];
				else if(j == i) dp[i][j] += dp[i-1][j-1];
				else dp[i][j] += Math.max(dp[i-1][j], dp[i-1][j-1]);
				max = Math.max(max, dp[i][j]);
			}
		}
		System.out.println(max);
		br.close();
	}
}

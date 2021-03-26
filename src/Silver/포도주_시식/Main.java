package Silver.포도주_시식;

import java.io.*;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int wine[] = new int[N+1];
		int dp[][] = new int[N+1][3];
		for(int i=1; i<N+1; i++) wine[i] = Integer.parseInt(br.readLine());

		dp[1][0] = wine[0];
		dp[1][1] = wine[1];
		dp[1][2] = wine[0] + wine[1];
		for(int i=2; i<N+1; i++) {
			dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
			dp[i][1] = dp[i-1][0] + wine[i];
			dp[i][2] = dp[i-1][1] + wine[i];
		}

		System.out.println(Math.max(dp[N][0], Math.max(dp[N][1], dp[N][2])));
		br.close();
	}
}

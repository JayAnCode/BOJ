package Silver.동물원;

import java.io.*;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int dp[][] = new int[N+1][3];

		dp[1][0] = dp[1][1] = dp[1][2] = 1;
		for(int i=2; i<N+1; i++) {
			dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
			dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
			dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901;
		}

		int ans = (dp[N][0]+dp[N][1]+dp[N][2]) % 9901;
		System.out.println(ans);
		br.close();
	}
}

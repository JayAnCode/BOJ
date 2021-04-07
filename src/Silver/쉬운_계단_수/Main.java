package Silver.쉬운_계단_수;

import java.io.*;

public class Main {
	static long num = 1000000000;
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long dp[][] = new long[N+1][10];

		for(int i=1; i<10; i++) dp[1][i] = 1;

		for(int i=2; i<N+1; i++) {
			for(int j=0; j<10; j++) {
				if(j == 9) dp[i][9] = dp[i-1][8];
				else if(j == 0) dp[i][0] = dp[i-1][1];
				else dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
				dp[i][j] %= num;
			}
		}

		long ans = 0;
		for(int i=0; i<10; i++) ans += dp[N][i];

		System.out.println(ans%num);
		br.close();
	}
}

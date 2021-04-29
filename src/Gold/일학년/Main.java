package Gold.일학년;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int num[] = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++)  num[i] = Integer.parseInt(st.nextToken());

		long[][] dp = new long[N][21];
		dp[1][num[1]] = 1;
		for(int i=2; i<N; i++) {
			for(int j=0; j<21; j++){
				if(dp[i-1][j] != 0) {
					if(j+num[i] <= 20) dp[i][j+num[i]] += dp[i-1][j];
					if(j-num[i] >= 0) dp[i][j-num[i]] += dp[i-1][j];
				}
			}
		}

		System.out.println(dp[N-1][num[N]]);
		br.close();
	}
}

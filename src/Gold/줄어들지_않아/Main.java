package Gold.줄어들지_않아;

import java.io.*;

public class Main {
	static int n;
	static long sum;
	static long dp[][];
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			n = Integer.parseInt(br.readLine());
			dp = new long[n+1][10];

			for(int i=0; i<=9; i++) dp[1][i] = 1;

			for(int i=2; i<n+1; i++) {
				for(int j=0; j<=9; j++) {
					for(int k=j; k<=9; k++) {
						dp[i][j] += dp[i-1][k];
					}
				}
			}

			sum = 0;
			for(int i=0; i<=9; i++) {
				sum += dp[n][i];
			}

			sb.append(sum + "\n");
		}

		System.out.print(sb.toString());
		br.close();
	}
}

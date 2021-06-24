package Gold.알약;

import java.io.*;

public class Main {
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		long dp[] = new long[31];
		dp[0] = 1; dp[1] = 1; dp[2] = 2;
		for(int i=3; i<31; i++) {
			for(int j=0; j<i; j++) {
				dp[i] += dp[j]*dp[i-j-1];
			}
		}	// 점화식은 A[N] = A[N-1]*A[0] + A[N-2]*A[1] + ...  + A[N-i-1]*A[i] +  ... + A[1]*A[N-2] + A[0]*A[N-1]

		int cnt = 1000;
		while(cnt-- > 0) {
			int N = Integer.parseInt(br.readLine());

			if(N == 0) break;

			sb.append(dp[N] + "\n");
		}

		System.out.print(sb.toString());
		br.close();
	}
}

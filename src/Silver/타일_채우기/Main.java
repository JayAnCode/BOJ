package Silver.타일_채우기;

import java.io.*;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N%2 == 1) System.out.println(0);
		else {
			int dp[] = new int[N + 1];
			dp[0] = 1;
			for (int i = 2; i < N + 1; i += 2) {
				dp[i] = dp[i - 2] * 3;
				for (int j = 0; j < i - 2; j += 2) {
					dp[i] += dp[j] * 2;
				}
			}
			System.out.println(dp[N]);
		}
		br.close();
	}
}

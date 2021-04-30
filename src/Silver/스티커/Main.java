package Silver.스티커;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static int N;
	static int sticker[][];
	static int dp[][];
	public static void main(String arg[]) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			N = Integer.parseInt(br.readLine());

			sticker = new int[2][N];
			for(int i=0; i<2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dp = new int[2][N];
			dp[0][0] = sticker[0][0]; dp[1][0] = sticker[1][0];
			dp[0][1] = dp[1][0]+sticker[0][1]; dp[1][1] = dp[0][0]+sticker[1][1];
			for(int j=2; j<N; j++) {
				for(int i=0; i<2; i++) {
					dp[i][j] = Math.max(dp[1-i][j-1], dp[1-i][j-2]) + sticker[i][j];
				}
			}
			sb.append(Math.max(dp[0][N-1], dp[1][N-1]) + "\n");
		}

		System.out.print(sb.toString());
		br.close();
	}
}

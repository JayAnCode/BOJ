package Gold.평범한_배낭;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int dp[][] = new int[K+1][N+1];
		int w[] = new int[N+1];
		int v[] = new int[N+1];
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=1; i<K+1; i++) {
			for(int j=1; j<N+1; j++) {
				if(i >= w[j]) {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-w[j]][j-1] + v[j]);
				}
				else {
					dp[i][j] = dp[i][j-1];
				}
			}
		}

		System.out.println(dp[K][N]);
		br.close();
	}
}

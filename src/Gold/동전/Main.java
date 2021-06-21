package Gold.동전;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int coin[] = new int[N];

			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				coin[i] = Integer.parseInt(st.nextToken());
			}

			int M = Integer.parseInt(br.readLine());
			int dp[] = new int[M+1];

			dp[0] = 1;
			for(int i=0; i<N; i++) {
				for(int j=coin[i]; j<M+1; j++) {
					dp[j] += dp[j-coin[i]];
				}	// j원을 만들기 위해서는 j-coin[i]월 + coin[i]원을 하면 된다.
			}

			sb.append(dp[M]+ "\n");
		}

		System.out.print(sb.toString());
		br.close();
	}
}

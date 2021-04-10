package Silver.카드_구매하기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int card[] = new int[N+1];
		int dp[] = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) card[i] = Integer.parseInt(st.nextToken());

		for(int i=1; i<N+1; i++) {
			dp[i] = card[i];
			for(int j=1; j<=i/2; j++) {
				dp[i] = Math.max(dp[i], dp[j]+dp[i-j]);
			}
		}
		System.out.println(dp[N]);
		br.close();
	}
}

package Gold.작업;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int ans = 0;
		int dp[] = new int[N+1];
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());

			int T = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int max = 0;
			for(int j=0; j<K; j++) {
				int num = Integer.parseInt(st.nextToken());

				max = Math.max(max, dp[num]);
			}	// 사전 작업 중 가장 긴 시간이 걸리는 사전 작업 찾기
			dp[i] = T + max;	// i번째 작업을 끝내는 시간은 i번 작업 시간 + 사전 작업 시간

			ans = Math.max(ans, dp[i]);	// N개의 작업 중 가장 오래 걸리는 작업 찾기
		}

		System.out.println(ans);
		br.close();
	}
}

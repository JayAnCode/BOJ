package Silver.연속합;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int dp[] = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) dp[i] = Integer.parseInt(st.nextToken());

		int max = dp[0];
		for(int i=1; i<N; i++) {
			if(dp[i-1]>0) dp[i] += dp[i-1];
			max = Math.max(max, dp[i]);
		}

		System.out.println(max);
		br.close();
	}
}

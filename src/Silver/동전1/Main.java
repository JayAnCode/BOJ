package Silver.동전1;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int coin[] = new int[n];
		int dp[] = new int[k+1];
		for(int i=0; i<n; i++) coin[i] = Integer.parseInt(br.readLine());

		dp[0] = 1;
		for(int i=0; i<n; i++) {
			for(int j=coin[i]; j<k+1; j++) {
				dp[j] += dp[j-coin[i]];
			}
		}

		System.out.println(dp[k]);
		br.close();
	}
}

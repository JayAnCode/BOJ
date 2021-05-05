package Silver.상자넣기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int box[] = new int[n+1];
		for(int i=1; i<n+1; i++) {
			box[i] = Integer.parseInt(st.nextToken());
		}

		int max = 1;
		int dp[] = new int[n+1];
		for(int i=1; i<n+1; i++) {
			dp[i] = 1;
			for(int j=1; j<i; j++) {
				if(box[j] < box[i]) dp[i] = Math.max(dp[i], dp[j]+1);
			}
			max = Math.max(max, dp[i]);
		}

		System.out.println(max);
		br.close();
	}
}

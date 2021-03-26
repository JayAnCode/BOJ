package Gold.LCS;

import java.io.*;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		char c1[] = str1.toCharArray();
		char c2[] = str2.toCharArray();
		int dp[][] = new int[c1.length+1][c2.length+1];

		for(int i=1; i<c1.length+1; i++) {
			for(int j=1; j<c2.length+1; j++) {
				if(c1[i-1] == c2[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
				else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}

		System.out.println(dp[c1.length][c2.length]);
		br.close();
	}
}

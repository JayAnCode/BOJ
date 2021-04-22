package Gold.LCS2;

import java.io.*;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		char c1[] = s1.toCharArray();
		char c2[] = s2.toCharArray();
		int dp[][] = new int[c1.length+1][c2.length+1];

		for(int i=1; i<c1.length+1; i++) {
			for(int j=1; j<c2.length+1; j++) {
				if(c1[i-1] == c2[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}

		int len1 = c1.length;
		int len2 = c2.length;
		String s = "";

		while(len1>=1 && len2>=1) {
			if(dp[len1][len2] == dp[len1-1][len2]) {
				len1 -= 1;
			}
			else if(dp[len1][len2] == dp[len1][len2-1]) {
				len2 -= 1;
			}
			else {
				s = c1[len1-1] + s;
				len1 -= 1; len2 -= 1;
			}
		}

		System.out.println(dp[c1.length][c2.length]);
		System.out.println(s);
		br.close();
	}
}

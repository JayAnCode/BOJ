package Gold.공통_부분_문자열;

import java.io.*;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		int dp[][] = new int[s1.length()+1][s2.length()+1];
		int max = 0;
		for(int i=1; i<s1.length()+1; i++) {
			for(int j=1; j<s2.length()+1; j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1] + 1;
					max = Math.max(max,dp[i][j]);
				}
			}
		}
		System.out.println(max);
		br.close();
	}
}

package Gold.가장_큰_정사각형;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int max = 0;
		int map[][] = new int[n][m];
		int dp[][] = new int[n][m];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = s.charAt(j)-'0';
				dp[i][j] = map[i][j];
				max = Math.max(max, dp[i][j]);
			}
		}

		for(int i=1; i<n; i++) {
			for(int j=1; j<m; j++) {
				if(map[i][j] == 1) {
					dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
					max = Math.max(max, dp[i][j]);
				}		// i,j의 왼쪽, 위쪽, 대각선 중 가장 작은 값 + 1이 정사각형을 이루는 한변의 길이, 가장 큰 값을 max에 저장
			}
		}

		System.out.println(max*max);
		br.close();
	}
}

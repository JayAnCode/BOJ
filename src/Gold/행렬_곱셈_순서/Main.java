package Gold.행렬_곱셈_순서;

import java.io.*;
import java.util.*;

public class Main {
	static int dp[][];
	static int row[];
	static int col[];
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		row = new int[N+1];
		col = new int[N+1];
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			row[i] = r;
			col[i] = c;
		}

		dp = new int[N+1][N+1];
		for(int i=1; i<N; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}	// dp[i][j]는 i번째 행렬부터 j번째 행렬까지 곱 중 최솟값

		int ans = calc(1, N);	// 곱의 최솟값을 찾기 위한 함수
		System.out.println(ans);
		br.close();
	}
	public static int calc(int start, int end) {
		if(start == end) {
			return 0;
		}	// 시작점과 끝점이 같으면 곱이 아니므로 0을 리턴

		if (dp[start][end] != Integer.MAX_VALUE) {
			return dp[start][end];
		}	// 시작점부터 끝점까지의 최솟값이 초기 설정 값이 아니면 이미 계산이 끝난 것이므로 해당 값 리턴

		for (int i = start; i < end; i++) {
			int sum = calc(start, i) + calc(i+1, end) + row[start] * col[i] * col[end];	// 시작점부터 i번째까지 i+1번째부터 끝점까지 행렬 곱 연산의 최솟값 계산
			dp[start][end] = Math.min(dp[start][end], sum);
		}

		return dp[start][end];
	}
}

package Gold.파일_합치기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int T, K;
	static int file[];
	static int sum[];
	static int dp[][];

	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			K = Integer.parseInt(br.readLine());

			file = new int[K];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<K; i++) {
				file[i] = Integer.parseInt(st.nextToken());
			}		// 파일 크기 입력

			sum = new int[K];
			sum[0] = file[0];
			for(int i=1; i<K; i++) {
				sum[i] = sum[i-1]+file[i];
			}		// 파일 크기의 누적 합 계산

			dp = new int[K][K];		// dp[i][j] -> i부터 j까지 파일을 합칠 때 가장 작은 값
			for(int i=0; i<K-1; i++) {
				dp[i][i+1] = file[i] + file[i+1];
			}		// i ~ i+1까지의 합은 i번째 파일과 i+1번째 파일 크기의 합

			for(int x=2; x<K; x++) {
				for(int i=0; i<K-x; i++) {
					if(i == 0) dp[i][i+x] = dp[i][i]+dp[i+1][i+x]+sum[i+x];		// 0번 파일부터 시작할 때 예외 처리
					else dp[i][i+x] = dp[i][i]+dp[i+1][i+x]+sum[i+x]-sum[i-1];

					for(int j=i+1; j<i+x; j++) {
						if(i == 0) dp[i][i+x] = Math.min(dp[i][j]+dp[j+1][i+x]+sum[i+x], dp[i][i+x]);		// 0번 파일부터 시작할 때 예외 처리
						else dp[i][i+x] = Math.min(dp[i][j]+dp[j+1][i+x]+sum[i+x]-sum[i-1], dp[i][i+x]);
					}		// 0번째 파일부터 i+x번째 파일까지 최소값 계산
				}		// 0번째 파일부터 K-x번째 파일까지 탐색
			}		// 파일 사이의 간격 x 증가

			sb.append(dp[0][K-1] + "\n");
		}

		System.out.println(sb.toString());
		br.close();
	}
}

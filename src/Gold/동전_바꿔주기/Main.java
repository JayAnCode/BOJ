package Gold.동전_바꿔주기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		int p[] = new int[k+1];
		int n[] = new int[k+1];
		for(int i=1; i<k+1; i++) {
			st = new StringTokenizer(br.readLine());
			p[i] = Integer.parseInt(st.nextToken());
			n[i] = Integer.parseInt(st.nextToken());
		}

		int dp[][] = new int[k+1][T+1];	// k가지 동전으로 T원을 만드는 방법
		dp[0][0] = 1;
		for(int i=1; i<k+1; i++) {
			for(int j=0; j<n[i]+1; j++) {
				for(int l=0; l<T+1; l++) {
					int temp = l + p[i]*j;	// 이미 만들어진 l원에 i번째 동전을 j번 사용해 temp원을 만듬

					if(temp > T) break;

					dp[i][temp] += dp[i-1][l];	// i-1번째 동전까지 사용해 l원을 만드는 방법을 더해줌
				}	// i번째 동전을 j개 사용해 temp원을 만드는 방법
			}
		}

		System.out.println(dp[k][T]);
	}
}

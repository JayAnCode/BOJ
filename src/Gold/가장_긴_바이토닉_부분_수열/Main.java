package Gold.가장_긴_바이토닉_부분_수열;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int seq[] = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		int max = 1;

		int dp1[] = new int[N+1];
		for(int i=1; i<N+1; i++) {
			dp1[i] = 1;
			for(int j=1; j<i; j++) {
				if(seq[j] < seq[i]) dp1[i] = Math.max(dp1[i], dp1[j]+1);
			}
		}//가장 긴 증가하는 부분 수열

		int dp2[] = new int[N+1];
		for(int i=N; i>0; i--) {
			dp2[i] = 1;
			for(int j=N; j>i; j--) {
				if(seq[j] < seq[i]) dp2[i] = Math.max(dp2[i], dp2[j]+1);
			}
			max = Math.max(max, dp1[i]+dp2[i]-1);//바이토닉 부분 수열
		}//가장 긴 증가하는 역 부분 수열

		System.out.println(max);
		br.close();
	}
}
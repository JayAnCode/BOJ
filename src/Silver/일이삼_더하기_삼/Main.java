package Silver.일이삼_더하기_삼;

import java.io.*;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long ans[] = new long[1000001];
		ans[1] = 1; ans[2] = 2; ans[3] = 4;
		for(int i=4; i<1000001; i++) {
			ans[i] = (ans[i-1]+ans[i-2]+ans[i-3])%1000000009;
		}
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(ans[N]);
		}
		br.close();
	}
}

package Silver.제곱수의_합;

import java.io.*;

public class Main {
	public static void main(String arg[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans[] = new int[N+1];
		ans[0] = 0;
		for(int i=1; i<=N; i++) {
			ans[i] = i;
			for(int j=1; j*j<=i; j++) {
				if(ans[i] > ans[i-j*j] + 1) {
					ans[i] = ans[i-j*j] + 1;
				}
			}
		}
		System.out.println(ans[N]);
	}
}

package Gold.줄세우기;

import java.io.*;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int line[] = new int[N+1];
		for(int i=1; i<N+1; i++) {
			line[i] = Integer.parseInt(br.readLine());
		}

		int ans = 1;
		int len[] = new int[N+1];
		for(int i=1; i<N+1; i++) {
			len[i] = 1;
			for(int j=1; j<i; j++) {
				if(line[j] < line[i] && len[i] < len[j]+1) {
					len[i] = len[j]+1;
				}
				ans = Math.max(ans, len[i]);
			}
		}

		ans = N-ans;
		System.out.println(ans);
		br.close();
	}
}

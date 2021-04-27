package Silver.IOIOI;

import java.io.*;

public class Main {
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String s = br.readLine();

		StringBuilder sb = new StringBuilder("I");
		for(int i=1; i<N+1; i++) {
			sb.append("O");
			sb.append("I");
		}

		String ioi = sb.toString();
		int ans = 0;
		int idx = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == ioi.charAt(idx)) {
				idx += 1;
				if(idx == ioi.length()) {
					ans += 1;
					idx -= 2;
				}
			}
			else {
				if(s.charAt(i) == 'I') idx = 1;
				else idx = 0;
			}
		}

		System.out.println(ans);
		br.close();
	}
}

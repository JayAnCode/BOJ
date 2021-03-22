package Silver.소수_구하기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		for(int i=M; i<=N; i++) {
			boolean flag = true;
			for(int j=2; j<=(int)Math.sqrt(i); j++) {
				if(i%j == 0) {
					flag = false;
					break;
				}
			}
			if(i!=1 && flag) sb.append(i+"\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}

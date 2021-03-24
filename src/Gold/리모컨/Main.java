package Gold.리모컨;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static boolean broken[] = new boolean[10];
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		if(M != 0) st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) broken[Integer.parseInt(st.nextToken())] = true;
		int ans = Math.abs(N - 100);
		for(int i=0; i<=1000000; i++) {
			int len = count(i);
			if(len > 0) {
				int num = Math.abs(N - i);
				ans = Math.min(ans, len+num);   // 최소 이동 횟수 계산
			}
		}
		System.out.println(ans);
		br.close();
	}
	public static int count(int i) {
		if(i == 0) {
			if (broken[0]) return 0;
			else return 1;
		}
		int len = 0;
		while(i > 0) {
			if (broken[i%10]) return 0;
			i /= 10;
			len += 1;
		}
		return len;
	}
}

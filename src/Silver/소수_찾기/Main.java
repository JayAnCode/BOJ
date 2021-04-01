package Silver.소수_찾기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int count = 0;
	static int N, input;
	static boolean flag;
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			input = Integer.parseInt(st.nextToken());
			if(input == 1) continue;
			flag = true;
			for(int j=2; j<=Math.sqrt(input); j++) {
				if(input%j == 0) {
					flag = false;
					break;
				}
			}
			if(flag) count++;
		}
		System.out.println(count);
		br.close();
	}
}

package Silver.N과M_2;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int num[];
	static boolean check[];
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[M];
		check = new boolean[N+1];
		go(0, 0);
		System.out.print(sb.toString());
		br.close();
	}
	public static void go(int cur, int a) {
		if(cur == M) {
			for(int i=0; i<num.length-1; i++) sb.append(num[i]+ " ");
			sb.append(num[num.length-1]+"\n");
			return;
		}
		for(int i=a+1; i<N+1; i++) {
			if(!check[i]) {
				check[i] = true;
				num[cur] = i;
				go(cur+1, i);
				check[i] = false;
			}
		}
	}
}

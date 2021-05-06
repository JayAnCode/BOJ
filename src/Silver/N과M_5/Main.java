package Silver.N과M_5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int num[], ans[];
	static boolean check[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		num = new int[N];
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);

		check = new boolean[N];
		ans = new int[M];
		go(ans, 0);

		System.out.print(sb.toString());
		br.close();
	}
	public static void go(int ans[], int count) {
		if(count == M) {
			for(int i=0; i<M; i++) {
				sb.append(ans[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for(int i=0; i<N; i++) {
			if(!check[i]) {
				check[i] = true;
				ans[count] = num[i];
				go(ans, count+1);
				check[i] = false;
			}
		}
	}
}

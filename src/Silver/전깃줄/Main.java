package Silver.전깃줄;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		TreeMap<Integer, Integer> map = new TreeMap<>();
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map.put(a, b);
		}

		int max = 0;
		int dp[] = new int[501];
		for(Integer i : map.keySet()) {
			dp[i] = 1;
			for(Integer j : map.keySet()) {
				if(j >= i) break;
				if(map.get(i) > map.get(j)) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(N-max);
	}
}

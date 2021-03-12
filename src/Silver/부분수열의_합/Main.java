package Silver.부분수열의_합;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N,S;
	static int arr[];
	static int ans = 0;
	static void dfs(int count, int sum) {
		if(count == N) {
			if(sum == S) ans++;
			return;
		}
		dfs(count+1, sum+arr[count]);
		dfs(count+1, sum);
	}
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0, 0);
		if(S==0) System.out.println(ans-1);
		else System.out.println(ans);
		br.close();
	}
}

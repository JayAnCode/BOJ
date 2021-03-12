package Silver.가장_큰_증가_부분수열;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N+1];
		int sum[] = new int[N+1];
		int ans = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum[i] = arr[i];
			for(int j=0; j<i; j++) {
				if(arr[j]<arr[i] && sum[i]<arr[i]+sum[j]) {
					sum[i] = sum[j]+arr[i];
				}
			}
			ans = Math.max(ans, sum[i]);
		}
		System.out.println(ans);
		br.close();
	}
}

package Silver.가장_긴_증가하는_부분수열;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];	// 수열의 전체 숫자
		int len[] = new int[N];	// 증가하는 부분 수열 길이

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

		int ans = -1;

		for(int i=0; i<N; i++) {
			len[i] = 1;

			for(int j=0; j<i; j++) {
				if((arr[j] < arr[i]) && (len[j]+1 > len[i])) {
					len[i] = len[j]+1;
				}	// 해당 index까지 가장 긴 증가 길이 저장
			}
			ans = Math.max(ans, len[i]);
		}

		System.out.println(ans);
		br.close();
	}
}

package Silver.주몽;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] arg) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		int ans = 0;
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i]+arr[j] == M) {
					ans++; break;
				}
			}
		}
		System.out.println(ans);
	}
}

package Silver.좌표_압축;

import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb;
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr1[] = new int[N];
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr1[i] = Integer.parseInt(st.nextToken());
		int arr2[] = arr1.clone();
		Arrays.sort(arr2);
		Map<Integer, Integer> map = new HashMap<>();
		int idx = 0;
		for (int i : arr2) {
			if (!map.containsKey(i)) map.put(i, idx++);
		}
		for (int i : arr1) sb.append(map.get(i)).append(' ');
		System.out.println(sb.toString());
		br.close();
	}
}

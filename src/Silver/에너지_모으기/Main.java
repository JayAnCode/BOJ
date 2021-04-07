package Silver.에너지_모으기;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N, max;
	static int marble[];
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		marble = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) marble[i] = Integer.parseInt(st.nextToken());

		LinkedList<Integer> list = new LinkedList<>();
		for(int i=0; i<N; i++) list.add(marble[i]);

		max = Integer.MIN_VALUE;
		go(list, 0);

		System.out.println(max);
		br.close();
	}
	public static void go(LinkedList<Integer> list, int sum) {
		if(list.size() == 2) {
			max = Math.max(max, sum);
			return;
		}

		for(int i=1; i<list.size()-1; i++) {
			int x = list.remove(i);
			go(list, sum + list.get(i-1)*list.get(i));
			list.add(i, x);
		}
	}
}

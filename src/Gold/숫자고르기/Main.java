package Gold.숫자고르기;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static int N, start;
	static int seq[];
	static boolean check[];
	static ArrayList<Integer> list;
	public static void main(String arg[]) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		seq = new int[N+1];
		for(int i=1; i<N+1; i++) seq[i] = Integer.parseInt(br.readLine());

		list = new ArrayList<>();
		for(int i=1; i<N+1; i++) {
			check = new boolean[N+1];
			start = i;
			dfs(start);
		}

		Collections.sort(list);

		sb.append(list.size() + "\n");
		for(Integer i : list) sb.append(i + "\n");
		System.out.print(sb.toString());
		br.close();
	}
	public static void dfs(int i) {
		if(seq[i] == start) list.add(start);

		check[i] = true;

		if(!check[seq[i]]) {
			check[seq[i]] = true;
			dfs(seq[i]);
		}
	}
}

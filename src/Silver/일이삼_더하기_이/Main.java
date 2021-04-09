package Silver.일이삼_더하기_이;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static ArrayList<String> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		go(0, "");
		Collections.sort(list);
		if(k > list.size()) System.out.println(-1);
		else System.out.println(list.get(k-1));
	}
	public static void go(int cur, String s) {
		if(cur == n) {
			list.add(s);
			return;
		}
		for(int i=1; i<=3; i++) {
			if(cur < n) {
				sb = new StringBuilder(s);
				if(sb.length() == 0) sb.append(i);
				else sb.append("+" + i);
				go(cur+i, sb.toString());
			}
		}
	}
}

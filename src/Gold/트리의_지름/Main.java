package Gold.트리의_지름;

import java.io.*;
import java.util.*;

public class Main {
	static int V, ans, root;
	static ArrayList<Pair> list[];
	static StringTokenizer st;
	static class Pair {
		int end;
		int len;
		public Pair(int end, int len) {
			this.end = end;
			this.len = len;
		}
	}
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		list = new ArrayList[V+1];
		for(int i=0; i<V+1; i++) list[i] = new ArrayList<>();
		for(int i=0; i<V; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				int end = Integer.parseInt(st.nextToken());
				if(end == -1) break;
				int len = Integer.parseInt(st.nextToken());
				list[start].add(new Pair(end, len));
			}
		}
		dfs(1,0,0);
		dfs(root,0,0);
		System.out.println(ans);
		br.close();
	}
	public static void dfs(int start, int par, int len) {
		if (len > ans) {
			ans = len;
			root = start;
		}
		for (int i = 0; i < list[start].size(); i++) {
			Pair p = list[start].get(i);
			if (p.end == par) continue;
			dfs(p.end, start, p.len + len);
		}
	}
}

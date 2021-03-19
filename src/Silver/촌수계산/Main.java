package Silver.촌수계산;

import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static Queue<Integer> q;
	static ArrayList<Integer> list[];
	static int dist[];
	static int ans = -1;
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		dist = new int[n+1];
		Arrays.fill(dist, -1);
		for(int i=0; i<n+1; i++) list[i] = new ArrayList<>();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[p].add(c);
			list[c].add(p);
		}
		q = new LinkedList<Integer>();
		bfs(a, b);
		System.out.println(ans);
		br.close();
	}
	static void bfs(int a, int b) {
		dist[a] = 0;
		q.add(a);
		while(!q.isEmpty()) {
			int now = q.poll();
			if(now == b) {
				ans = dist[now];
				break;
			}
			for (int i=0; i<list[now].size(); i++) {
				int tmp = list[now].get(i);
				if(dist[tmp] == -1){
					dist[tmp] = dist[now] + 1;
					q.add(tmp);
				}
			}
		}
	}
}

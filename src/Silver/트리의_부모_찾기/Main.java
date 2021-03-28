package Silver.트리의_부모_찾기;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static ArrayList<Integer> list[];
	static Queue<Integer> q;
	static int N, u, v;
	static int parent[];
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		list = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) list[i] = new ArrayList<>();
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
		bfs(1);
		for(int i=2; i<N+1; i++) System.out.println(parent[i]);
		br.close();
	}
	static void bfs(int root) {
		q = new LinkedList<>();
		q.offer(root);
		parent[root] = -1;
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int i : list[x]) {
				if(list[x].contains(i) && parent[i] == 0) {
					q.offer(i);
					parent[i] = x;
				}
			}
		}
	}
}

package Gold.트리의_지름_2;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, max, node;
	static ArrayList<Node> list[];
	static boolean visited[];
	static class Node {
		int link;
		int weight;
		public Node(int link, int weight) {
			this.link = link;
			this.weight = weight;
		}
	}
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) list[i] = new ArrayList<>();

		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[p].add(new Node(c, w));
			list[c].add(new Node(p, w));
		}

		max = 0; node = 1;
		visited = new boolean[N+1];
		visited[node] = true;
		dfs(node, 0);		// 루트부터 가장 먼 노드 찾기

		visited = new boolean[N+1];
		visited[node] = true;
		dfs(node, 0);		// 루트부터 가장 먼 노드부터 가장 먼 노드 찾기

		System.out.println(max);
		br.close();
	}

	public static void dfs(int index, int sum) {
		if(max < sum) {
			max = sum;
			node = index;
		}

		for(Node n : list[index]) {
			if(!visited[n.link]) {
				visited[n.link] = true;
				dfs(n.link, sum+n.weight);
			}
		}
	}
}

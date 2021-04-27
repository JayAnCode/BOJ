package Silver.케빈_베이컨의_6단계_법칙;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, sum, min, ans;
	static int graph[][];
	static boolean check[];
	static class Pair {
		int node;
		int count;
		public Pair(int node, int count) {
			this.node = node;
			this.count = count;
		}
	}
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new int[N+1][N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = graph[b][a] = 1;
		}

		min = Integer.MAX_VALUE;
		ans = 0;
		for(int i=1; i<N+1; i++) {
			sum = 0;
			check = new boolean[N+1];
			bfs(i);

			if(min > sum) {
				min = sum;
				ans = i;
			}
		}
		System.out.println(ans);
		br.close();
	}
	public static void bfs(int start) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(start, 0));
		check[start] = true;

		while(!q.isEmpty()) {
			Pair p = q.poll();
			sum += p.count;

			for(int i=1; i<N+1; i++) {
				if(p.node == i) continue;

				if(graph[p.node][i] == 1 && !check[i]) {
					q.offer(new Pair(i, p.count+1));
					check[i] = true;
				}
			}
		}
	}
}

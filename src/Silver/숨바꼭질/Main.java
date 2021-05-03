package Silver.숨바꼭질;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, num, max, count;
	static boolean check[];
	static ArrayList<Integer> list[];
	static class Node {
		int x;
		int dist;
		public Node(int x, int dist) {
			this.x = x;
			this.dist = dist;
		}
	}
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) list[i] = new ArrayList<>();

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		num = 0; max = 0; count = 0;
		check = new boolean[N+1];
		bfs(1, 0);

		System.out.println(num + " " + max + " " + count);
		br.close();
	}
	public static void bfs(int x, int dist) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, dist));
		check[x] = true;

		while(!q.isEmpty()) {
			Node n = q.poll();

			if(max < n.dist) {
				max = n.dist;
				num = n.x;
				count = 1;
			}
			else if(max == n.dist) {
				if(num > n.x) num = n.x;
				count++;
			}

			for(int i : list[n.x]) {
				if(!check[i]) {
					q.offer(new Node(i, n.dist+1));
					check[i] = true;
				}
			}
		}
	}
}

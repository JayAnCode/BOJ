package Gold.회장뽑기;

import java.io.*;
import java.util.*;

public class Main {
	static int n, min, sum;
	static int friend[][];
	static boolean check[];
	static TreeSet<Integer> set = new TreeSet<>();
	static class Node {
		int x;
		int point;
		public Node(int x, int point) {
			this.x = x;
			this.point = point;
		}
	}

	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		friend = new int[n+1][n+1];
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if(a == -1 && b == -1) break;

			friend[a][b] = friend[b][a] = 1;
		}

		min = Integer.MAX_VALUE;
		for(int i=1; i<n+1; i++) {
			sum = 0;
			check = new boolean[n+1];
			bfs(i, 0);
			if(sum < min) {
				min = sum;
				set.clear();
				set.add(i);
			}
			else if(sum == min) set.add(i);
		}

		sb.append(min + " " + set.size() + "\n");
		for(int i : set) sb.append(i + " ");

		System.out.println(sb.toString());
		br.close();
	}
	public static void bfs(int x, int point) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, point));
		check[x] = true;

		while(!q.isEmpty()) {
			Node node = q.poll();
			sum = node.point;
			for(int i=1; i<n+1; i++) {
				if(friend[node.x][i] == 1 && !check[i]) {
					q.offer(new Node(i, node.point+1));
					check[i] = true;
				}
			}
		}
	}
}

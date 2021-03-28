package Silver.바이러스;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static Queue<Integer> q;
	static int n,m, count;
	static boolean com[];
	static int net[][];
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		com = new boolean[n+1];
		net = new int[n+1][n+1];
		m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			net[a][b] = net[b][a] = 1;
		}
		bfs(1);
		System.out.println(count);
		br.close();
	}
	public static void bfs(int a) {
		q = new LinkedList<>();
		com[a] = true;
		q.offer(a);
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int i=0; i<net[x].length; i++) {
				if(net[x][i] == 1 && !com[i]) {
					com[i] = true;
					q.offer(i);
					count++;
				}
			}
		}
	}
}

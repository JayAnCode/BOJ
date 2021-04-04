package Silver.순열_사이클;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, ans;
	static int node[][];
	static boolean check[];
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			N = Integer.parseInt(br.readLine());
			node = new int[N+1][N+1];
			check = new boolean[N+1];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=1; i<N+1; i++) {
				int num = Integer.parseInt(st.nextToken());
				node[i][num] = node[num][i] = 1;
			}
			ans = 0;
			for(int i=1; i<N+1; i++) {
				if(!check[i]) {
					bfs(i);
					ans++;
				}
			}
			sb.append(ans+"\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
	public static void bfs(int u) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(u);
		check[u] = true;
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int i=1; i<N+1; i++) {
				if(node[x][i]==1 && !check[i]) {
					q.offer(i);
					check[i] = true;
					break;
				}
			}
		}
	}
}

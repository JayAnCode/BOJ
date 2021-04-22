package Silver.경로_찾기;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	static int N;
	static int graph[][];
	static boolean check[];
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<N; i++) {
			check = new boolean[N];
			for(int j=0; j<N; j++) {
				if(graph[i][j] == 1) {
					go(i, j);
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}
		br.close();
	}
	public static void go(int row, int col) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(col);
		check[col] = true;
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int i=0; i<N; i++) {
				if(graph[x][i] == 1 && !check[i]) {
					graph[row][i] = 1;
					q.offer(i);
					check[i] = true;
				}
			}
		}
	}
}
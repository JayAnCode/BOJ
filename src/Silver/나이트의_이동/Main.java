package Silver.나이트의_이동;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int l, nowR, nowC, goalR, goalC;
	static boolean check[][];
	static int dx[] = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int dy[] = {1, 2, 2, 1, -1, -2, -2, -1};
	public static class Pair {
		int row;
		int col;
		int count;
		public Pair(int row, int col, int count) {
			this.row = row;
			this.col = col;
			this.count = count;
		}
	}
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			l = Integer.parseInt(br.readLine());
			check = new boolean[l][l];

			st = new StringTokenizer(br.readLine());
			nowR = Integer.parseInt(st.nextToken());
			nowC = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			goalR = Integer.parseInt(st.nextToken());
			goalC = Integer.parseInt(st.nextToken());

			sb.append(bfs(nowR, nowC, 0)+"\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
	public static int bfs(int row, int col, int count) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(row, col, count));
		check[row][col] = true;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			if(p.row==goalR && p.col==goalC) return p.count;
			for(int i=0; i<8; i++) {
				int nRow = p.row+dy[i];
				int nCol = p.col+dx[i];
				if((nRow>=0 && nRow<l) && (nCol>=0 && nCol<l)) {
					if(!check[nRow][nCol]) {
						q.offer(new Pair(nRow, nCol, p.count+1));
						check[nRow][nCol] = true;
					}
				}
			}
		}
		return 0;
	}
}

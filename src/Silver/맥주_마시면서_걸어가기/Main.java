package Silver.맥주_마시면서_걸어가기;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Loc loc[];
	static boolean check[];
	public static class Loc {
		int x;
		int y;
		public Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			N = Integer.parseInt(br.readLine());
			loc = new Loc[N+2];
			check = new boolean[N+2];

			for(int i=0; i<N+2; i++) {
				st = new StringTokenizer(br.readLine());
				loc[i] = new Loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			boolean flag = bfs();
			sb.append(flag ? "happy" : "sad");
			sb.append("\n");
		}

		System.out.print(sb.toString());
		br.close();
	}
	public static boolean bfs() {
		Queue<Loc> q = new LinkedList<>();
		q.offer(loc[0]);
		check[0] = true;

		while(!q.isEmpty()) {
			Loc cur = q.poll();

			if(cur == loc[N+1]) return true;

			for(int i=1; i<N+2; i++) {
				if(!check[i] && (Math.abs(cur.x-loc[i].x)+Math.abs(cur.y-loc[i].y) <= 1000)) {
					q.offer(loc[i]);
					check[i] = true;
				}
			}
		}

		return false;
	}
}

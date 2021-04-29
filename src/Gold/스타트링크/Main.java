package Gold.스타트링크;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int f, s, g, u, d, ans;
	static boolean flag;
	static boolean check[];
	static class Loc {
		int floor;
		int count;
		public Loc(int floor, int count) {
			this.floor = floor;
			this.count = count;
		}
	}

	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		f = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		u = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		check = new boolean[f+1];
		flag = false;
		bfs(s, 0);

		if(flag) System.out.println(ans);
		else System.out.println("use the stairs");

		br.close();
	}

	public static void bfs(int s, int c) {
		Queue<Loc> q = new LinkedList<>();
		q.offer(new Loc(s, c));
		check[s] = true;

		while(!q.isEmpty()) {
			Loc l = q.poll();
			if(l.floor == g) {
				ans = l.count;
				flag = true;
			}

			if(l.floor+u <= f) {
				if(!check[l.floor+u]) {
					q.offer(new Loc(l.floor+u, l.count+1));
					check[l.floor+u] = true;
				}
			}

			if(l.floor-d > 0) {
				if(!check[l.floor-d]) {
					q.offer(new Loc(l.floor-d, l.count+1));
					check[l.floor-d] = true;
				}
			}
		}
	}
}

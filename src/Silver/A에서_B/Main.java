package Silver.A에서_B;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int ans;
	static class Pair {
		long x;
		int count;
		public Pair(long x, int count) {
			this.x = x;
			this.count = count;
		}
	}
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());

		ans = -1;
		bfs(A, B);

		System.out.println(ans);
		br.close();
	}
	public static void bfs(long A, long B) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(A, 1));

		while(!q.isEmpty()) {
			Pair p = q.poll();

			if(p.x == B) {
				ans = p.count;
				break;
			}

			long next1 = p.x*2;
			if(next1 <= B) q.offer(new Pair(next1, p.count+1));

			long next2 = p.x*10 + 1;
			if(next2 <= B) q.offer(new Pair(next2, p.count+1));
		}
	}
}

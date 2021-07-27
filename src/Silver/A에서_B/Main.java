package Silver.A에서_B;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int ans = -1;	// 만들 수 없는 경우엔 -1을 출력하므로 -1로 초기화
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
		long A = Integer.parseInt(st.nextToken());	// A 입력
		long B = Integer.parseInt(st.nextToken());	// B 입력

		bfs(A, B);	// A에서 B로 가는 최소 연산 계산

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
				return;
			}	// A가 B 변환 완료되면 bfs 종료

			long next1 = p.x*2;	// 1번 연산
			if(next1 <= B) q.offer(new Pair(next1, p.count+1));

			long next2 = p.x*10 + 1;	// 2번 연산
			if(next2 <= B) q.offer(new Pair(next2, p.count+1));
		}
	}
}

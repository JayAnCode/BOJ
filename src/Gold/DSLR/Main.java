package Gold.DSLR;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int A, B, min;
	static String ans;
	static boolean visited[];

	static class DSLR {
		int cur;
		int cnt;
		String com;
		public DSLR(int cur, int cnt, String com) {
			this.cur = cur;
			this.cnt = cnt;
			this.com = com;
		}
	}	// 현재 숫자, DSLR 변환 횟수, DSLR 명령어 누적

	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());

			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			min = Integer.MAX_VALUE;
			ans = "";
			visited = new boolean[10000];
			bfs();

			sb.append(ans + "\n");
		}

		System.out.print(sb.toString());
		br.close();
	}
	public static void bfs() {
		Queue<DSLR> q = new LinkedList<>();
		q.offer(new DSLR(A, 0, ""));
		visited[A] = true;

		while(!q.isEmpty()) {
			DSLR d = q.poll();

			if(d.cur == B) {
				min = Math.min(min, d.cnt);
				ans = d.com;
				break;
			}	// 변환 값이 B와 같으면 루프 종료

			for(int i=0; i<4; i++) {
				if(i == 0) {
					int num = goD(d.cur);
					if(!visited[num]) {
						q.offer(new DSLR(num, d.cnt+1, d.com+"D"));
						visited[num] = true;
					}
				}	// D 명령어 수행
				else if(i == 1) {
					int num = goS(d.cur);
					if(!visited[num]) {
						q.offer(new DSLR(num, d.cnt+1, d.com+"S"));
						visited[num] = true;
					}
				}	// S 명령어 수행
				else if(i == 2) {
					int num = goL(d.cur);
					if(!visited[num]) {
						q.offer(new DSLR(num, d.cnt+1, d.com+"L"));
						visited[num] = true;
					}
				}	// L 명령어 수행
				else {
					int num = goR(d.cur);
					if(!visited[num]) {
						q.offer(new DSLR(num, d.cnt+1, d.com+"R"));
						visited[num] = true;
					}
				}	// R 명령어 수행
			}
		}
	}
	public static int goD(int number) {
		int num = number*2;

		if(num > 9999) num %= 10000;

		return num;
	}
	public static int goS(int number) {
		int num = number;

		if(number == 0) num = 9999;
		else num = number-1;

		return num;
	}
	public static int goL(int number) {
		int num = (number%1000)*10 + number/1000;

		return num;
	}
	public static int goR(int number) {
		int num = (number%10)*1000 + number/10;

		return num;
	}
}

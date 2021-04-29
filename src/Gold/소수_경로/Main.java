package Gold.소수_경로;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int a, b, ans;
	static boolean prime[];
	static boolean check[];
	static class Pair {
		int x;
		int c;
		public Pair(int x, int c) {
			this.x = x;
			this.c = c;
		}
		public int getFir() { return x/1000; }
		public int getSec() { return (x%1000)/100; }
		public int getThi() { return (x%100)/10; }
		public int getForth() { return x%10; }
	}

	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		prime = new boolean[10000];
		Arrays.fill(prime, true);
		init();

		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			check = new boolean[10000];
			ans = 0;
			bfs(a, 0);

			sb.append(ans + "\n");
		}

		System.out.print(sb.toString());
		br.close();
	}
	public static void bfs(int start, int count) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(start, count));
		check[start] = true;

		while(!q.isEmpty()) {
			Pair p = q.poll();
			if(p.x == b) {
				ans = p.c;
				break;
			}
			for(int j=0; j<10; j++) {
				if(j != p.getFir() && j != 0) {
					int num = j*1000 + p.getSec()*100 + p.getThi()*10 + p.getForth();
					if(prime[num] && !check[num]) {
						q.offer(new Pair(num, p.c+1));
						check[num] = true;
					}
				}
				if(j != p.getSec()) {
					int num = j*100 + p.getFir()*1000 + p.getThi()*10 + p.getForth();
					if(prime[num] && !check[num]) {
						q.offer(new Pair(num, p.c+1));
						check[num] = true;
					}
				}
				if(j != p.getThi()) {
					int num = j*10 + p.getFir()*1000 + p.getSec()*100 + p.getForth();
					if(prime[num] && !check[num]) {
						q.offer(new Pair(num, p.c+1));
						check[num] = true;
					}
				}
				if(j != p.getForth()) {
					int num = j + p.getFir()*1000 + p.getSec()*100 + p.getThi()*10;
					if(prime[num] && !check[num]) {
						q.offer(new Pair(num, p.c+1));
						check[num] = true;
					}
				}
			}
		}
	}

	public static void init() {
		for(int i=1000; i<10000; i++) {
			if(i%2 == 0) {
				prime[i] = false;
				continue;
			}
			for(int j=3; j<=(int)Math.sqrt(i); j+=2) {
				if(i%j == 0) {
					prime[i] = false;
					break;
				}
			}
		}
	}
}


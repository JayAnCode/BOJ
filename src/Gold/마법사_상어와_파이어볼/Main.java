package Gold.마법사_상어와_파이어볼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, ans;
	static LinkedList<Fire>[][] fireball;
	static int dx[] = {0, 1, 1, 1, 0 ,-1, -1, -1};
	static int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static class Fire{
		int m, s, d;
		public Fire(int m, int s, int d) {
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		fireball = new LinkedList[N+1][N+1];
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				fireball[i][j] = new LinkedList<>();
			}
		}

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			fireball[r][c].add(new Fire(m, s, d));
		}

		while(K-- > 0) {
			fireball = step1();
			step2();
		}
		ans = step3();
		System.out.println(ans);
	}

	public static LinkedList<Fire>[][] step1() {
		LinkedList<Fire>[][] temp = new LinkedList[N+1][N+1];
		for (int i=1; i<N+1; i++) {
			for (int j=1; j<N+1; j++) {
				temp[i][j] = new LinkedList<Fire>();
			}
		}

		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				while(fireball[i][j].size() > 0) {
					Fire f = fireball[i][j].remove(0);
					int next_r = i + dy[f.d]*(f.s%N);
					int next_c = j + dx[f.d]*(f.s%N);

					if(next_r > N) next_r -= N;
					else if(next_r < 1) next_r += N;

					if(next_c > N) next_c -= N;
					else if(next_c < 1) next_c += N;

					temp[next_r][next_c].add(new Fire(f.m, f.s, f.d));
				}
			}
		}

		return temp;
	}

	public static void step2() {
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				if(fireball[i][j].size() > 1) {
					int sum_m = 0;
					int sum_s = 0;
					boolean flag_e = false;
					boolean flag_o = false;
					int size = fireball[i][j].size();

					while(fireball[i][j].size() > 0) {
						Fire f = fireball[i][j].remove();
						sum_m += f.m;
						sum_s += f.s;
						if(f.d%2 == 0) flag_e = true;
						else flag_o = true;
					}

					sum_m = sum_m/5;
					sum_s = sum_s/size;

					if(sum_m == 0) continue;

					if(flag_e && flag_o) {
						fireball[i][j].add(new Fire(sum_m, sum_s, 1));
						fireball[i][j].add(new Fire(sum_m, sum_s, 3));
						fireball[i][j].add(new Fire(sum_m, sum_s, 5));
						fireball[i][j].add(new Fire(sum_m, sum_s, 7));
					}
					else {
						fireball[i][j].add(new Fire(sum_m, sum_s, 0));
						fireball[i][j].add(new Fire(sum_m, sum_s, 2));
						fireball[i][j].add(new Fire(sum_m, sum_s, 4));
						fireball[i][j].add(new Fire(sum_m, sum_s, 6));
					}
				}
			}
		}
	}
	public static int step3() {
		int sum = 0;
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				for(Fire f : fireball[i][j]) {
					sum += f.m;
				}
			}
		}
		return sum;
	}
}

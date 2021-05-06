package Gold.N_Queen;

import java.io.*;

public class Main {
	static int N, ans;
	static int queen[];
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ans = 0;
		N = Integer.parseInt(br.readLine());
		for(int i=1; i<N+1; i++) {
			queen = new int[N+1];
			queen[1] = i;
			go(2);
		}

		System.out.println(ans);
		br.close();
	}
	public static void go(int idx) {
		if(idx == N+1) {
			ans++;
			return;
		}

		for(int i=1; i<N+1; i++) {
			if (check(idx, i)) {
				queen[idx] = i;
				go(idx+1);
			}
		}
	}

	public static boolean check(int idx, int num) {
		for(int i=1; i<idx; i++) {
			if(queen[i] == num) return false;
			if(Math.abs(idx-i) == Math.abs(num-queen[i])) return false;
		}

		return true;
	}
}

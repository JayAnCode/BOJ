package Silver.퇴사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static int N;
	static int T[], P[];
	static int ans;
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		T = new int[N];
		P = new int[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		ans = 0;
		go(0, 0);

		System.out.println(ans);
		br.close();
	}
	public static void go(int sum, int day) {
		if(day > N) return;
		else if(day == N) {
			ans = Math.max(ans, sum);
			return;
		}

		go(sum, day + 1);
		go(sum + P[day], day + T[day]);
	}
}

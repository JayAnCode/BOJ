package Silver.공유기_설치;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, C, count, ans;
	static int house[];
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		house = new int[N];
		for(int i=0; i<N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(house);

		ans = 0;
		go(1, house[N-1]-house[0]);

		System.out.println(ans);
		br.close();
	}
	public static void go(int start, int end) {
		if(start > end) return;

		int mid = (start+end)/2;	//최대 거리 값 이분 탐색

		check(mid);

		if(count >= C) {
			ans = Math.max(ans, mid);
			go(mid+1, end);
		}	//설치된 공유기 수가 주어진 공유기 수보다 많으면 거리를 늘려서 다시 탐색
		else {
			go(start, mid-1);
		}	//설치된 공유기 수가 주어진 공유기 수보다 적으면 거리를 줄여서 다시 탐색
	}

	public static void check(int dist) {
		int first = house[0];
		count = 1;

		for(int i=1; i<N; i++) {
			if(first + dist <= house[i]) {
				first = house[i];
				count++;
			}	//설치된 (집 + 최대 거리)보다 다음 집까지의 거리가 멀면 다음 집에 공유기 추가
		}
	}
}

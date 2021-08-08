package Gold.N번째_큰_수;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());	// 우선순위 큐 역순으로 정렬(내림차순)

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());

			while(st.hasMoreTokens()) {	// 입력 수를 전부 우선순위 큐에 저장함으로서 자동 정렬 가능
				pq.add(Integer.parseInt(st.nextToken()));
			}
		}

		int ans = 0;
		for(int i=0; i<N; i++) {	// N번째 큰 수 찾기
			ans = pq.poll();
		}

		System.out.println(ans);
		br.close();
	}
}

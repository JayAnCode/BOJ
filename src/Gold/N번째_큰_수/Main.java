package Gold.N번째_큰_수;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String arg[]) throws IOException {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) pq.add(Integer.parseInt(st.nextToken()));
		}
		for(int i=0; i<N-1; i++) pq.poll();
		System.out.println(pq.peek());
		br.close();
	}
}

package Silver.절댓값_힙;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) ->
				Math.abs(o1) == Math.abs(o2) ? Integer.compare(o1, o2) : Integer.compare(Math.abs(o1), Math.abs(o2)));
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(pq.isEmpty()) System.out.println(0);
				else {
					System.out.println(pq.poll());
				}
			}
			else pq.add(x);
		}
		br.close();
	}
}

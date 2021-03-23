package Silver.최소_힙;

import java.io.*;
import java.util.PriorityQueue;

public class Main {
	static PriorityQueue<Integer> pq;
	static StringBuilder sb;
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<>();
		sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(pq.isEmpty()) sb.append("0\n");
				else sb.append(pq.poll()+"\n");
			}
			else pq.add(x);
		}
		System.out.print(sb.toString());
		br.close();
	}
}

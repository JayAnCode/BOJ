package Silver.최대_힙;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		while(N-->0) {
			int x = Integer.parseInt(br.readLine());
			if(x != 0) {
				pq.add(x);
			}
			else {
				if(pq.isEmpty()) System.out.println(0);
				else System.out.println(pq.poll());
			}
		}
		br.close();
	}
}

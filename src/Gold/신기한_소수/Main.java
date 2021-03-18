package Gold.신기한_소수;

import java.io.*;
import java.util.*;

public class Main {
	static Queue<Integer> q = new LinkedList<>();
	static int odd[] = new int[] {1, 3, 5, 7, 9};
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		q.offer(2);
		q.offer(3);
		q.offer(5);
		q.offer(7);
		while(!q.isEmpty()) {
			if(String.valueOf(q.peek()).length()==N) {
				System.out.println(q.poll());
				continue;
			}
			int num = q.poll();
			for(int i=0; i<odd.length; i++) {
				int next = num*10+odd[i];
				boolean flag = true;
				for(int j=3; j<=(int)Math.sqrt(next); j+=2) {
					if(next%j == 0) {
						flag = false;
						break;
					}
				}
				if(flag) q.offer(next);
			}
		}
		br.close();
	}
}

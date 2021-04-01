package Silver.프린터_큐;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb;
	static int N, M, count;
	static LinkedList<Integer> list;
	static Queue<Integer> q;
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			list = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) list.add(Integer.parseInt(st.nextToken()));
			q = new LinkedList<>(list);
			Collections.sort(list, Collections.reverseOrder());

			count = 0;
			while(!q.isEmpty()) {
				int print = q.poll();
				M -= 1;
				if(print < list.get(0)) {
					q.offer(print);
					if(M == -1)M = q.size()-1;
				}
				else if(print == list.get(0)){
					count++;
					if(M == -1) break;
					else list.remove(0);
				}
			}
			sb.append(count+"\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}

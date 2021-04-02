package Silver.AC;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static Deque<Integer> dq;
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			String s = br.readLine();
			int n  = Integer.parseInt(br.readLine());
			String arr = br.readLine();
			if(n==0) {
				if(s.contains("D")) sb.append("error\n");
				else sb.append("[]\n");
				continue;
			}
			arr = arr.substring(1, arr.length()-1);
			StringTokenizer st = new StringTokenizer(arr, ",");
			dq = new LinkedList<>();
			while(st.hasMoreTokens()) dq.offer(Integer.parseInt(st.nextToken()));

			boolean flag = true;
			boolean R = true;
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i) == 'R') {
					R = !R;
				}
				else if(s.charAt(i) == 'D') {
					if(dq.isEmpty()) {
						sb.append("error\n");
						flag = false;
						break;
					}
					else if(R){
						dq.pollFirst();
					}
					else if(!R) {
						dq.pollLast();
					}
				}
			}
			if(flag) {
				sb.append("[");
				if(R) {
					while(dq.size()>1) sb.append(dq.pollFirst()+",");
				}
				else {
					while(dq.size()>1) sb.append(dq.pollLast()+",");
				}
				if(!dq.isEmpty()) sb.append(dq.poll());
				sb.append("]\n");
			}
		}
		System.out.print(sb.toString());
		br.close();
	}
}

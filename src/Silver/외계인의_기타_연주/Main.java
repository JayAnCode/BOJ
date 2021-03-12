package Silver.외계인의_기타_연주;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> s[] = new Stack[7];
		for(int i=0; i<7; i++) s[i] = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int ans = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			while(!s[a].isEmpty() && s[a].peek()>b) {
				s[a].pop();
				ans++;
			}
			if(s[a].isEmpty() || s[a].peek()<b) {
				s[a].push(b);
				ans++;
			}
		}
		System.out.println(ans);
		br.close();
	}
}

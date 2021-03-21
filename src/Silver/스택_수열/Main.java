package Silver.스택_수열;

import java.io.*;
import java.util.Stack;

public class Main {
	static Stack<Integer> st = new Stack<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int arr[] = new int[n];
		for(int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());

		int cur = 0;
		for(int i=1; i<=n; i++) {
			st.push(i);
			sb.append("+\n");
			while(cur<=n) {
				if(!st.isEmpty() && st.peek() == arr[cur]) {
					st.pop();
					sb.append("-\n");
					cur++;
				}
				else break;
			}
		}

		if(st.isEmpty()) System.out.println(sb.toString());
		else System.out.println("NO");

		br.close();
	}
}

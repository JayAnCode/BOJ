package Silver.후위_표기식2;

import java.io.*;
import java.util.Stack;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		Stack<Double> stack = new Stack<>();
		int arr[] = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)-'A'<0 || s.charAt(i)-'A'>25) {
				double first = stack.pop();
				double second = stack.pop();
				if(s.charAt(i) == '+') stack.add(second+first);
				else if(s.charAt(i) == '-') stack.add(second-first);
				else if(s.charAt(i) == '*') stack.add(second*first);
				else if(s.charAt(i) == '/') stack.add(second/first);
			}
			else {
				stack.add((double)arr[s.charAt(i)-'A']);
			}
		}
		System.out.println(String.format("%.2f", stack.pop()));
		br.close();
	}
}

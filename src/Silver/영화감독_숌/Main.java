package Silver.영화감독_숌;

import java.io.*;
import java.util.Stack;

public class Main {
	public static void main(String args[]) throws IOException {

		Stack<String> stack = new Stack<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 666;
		while(stack.size()<n){
			String s = Integer.toString(count);
			if(s.contains("666")) stack.push(s);
			count++;
		}
		System.out.println(Integer.parseInt(stack.peek()));
	}
}

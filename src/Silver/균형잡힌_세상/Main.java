package Silver.균형잡힌_세상;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] arg) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String s = br.readLine();
			if(s.equals(".")) break;
			Stack<Character> stack = new Stack<Character>();
			boolean ans = true;
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i) == '(' || s.charAt(i) == '[') stack.push(s.charAt(i));
				else if(s.charAt(i) == ')') {
					if(stack.isEmpty() || stack.peek() != '(') {
						ans = false;
						break;
					}
					else stack.pop();
				}
				else if(s.charAt(i) == ']') {
					if(stack.isEmpty() || stack.peek() != '[') {
						ans = false;
						break;
					}
					else stack.pop();
				}
			}
			if(stack.isEmpty() && ans == true) System.out.println("yes");
			else System.out.println("no");
		}
		br.close();
	}
}

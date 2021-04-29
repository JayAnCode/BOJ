package Silver.회문;

import java.io.*;

public class Main {
	public static void main(String arg[]) throws  Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			String s = br.readLine();

			if(step1(s)) {
				sb.append(0 + "\n");
				continue;
			}
			if(step2(s)) {
				sb.append(1 + "\n");
				continue;
			}
			sb.append(2 + "\n");
		}

		System.out.println(sb.toString());
		br.close();
	}
	public static boolean step1(String s) {
		if(palindrome(s)) return true;
		return false;
	}
	public static boolean step2(String s) {
		for(int i=0; i<s.length()/2; i++) {
			String temp = s.substring(0, i) + s.substring(i+1);
			if(palindrome(temp)) return true;
		}
		return false;
	}
	public static boolean palindrome(String s) {
		for(int i=0; i<s.length()/2; i++) {
			if(s.charAt(i) != s.charAt(s.length()-i-1)) return false;
		}
		return true;
	}
}

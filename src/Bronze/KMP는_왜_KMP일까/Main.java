package Bronze.KMP는_왜_KMP일까;

import java.util.*;

public class Main {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		StringBuilder sb = new StringBuilder();
		sb.append(s.charAt(0));
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '-') sb.append(s.charAt(i+1));
		}
		String ans = sb.toString();
		System.out.println(ans);
	}
}

package Bronze.명령프롬프트;

import java.util.*;

public class Main {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] s= new String[n];
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) s[i] = sc.next();
		for(int i=0; i<s[0].length(); i++) {
			int count = 0;
			for(int j=0; j<n-1; j++) {
				if(s[j].charAt(i) != s[j+1].charAt(i)) {
					count++;
					break;
				}
			}
			if(count != 0) sb.append("?");
			else sb.append(s[0].charAt(i));
		}
		System.out.println(sb.toString());
	}
}

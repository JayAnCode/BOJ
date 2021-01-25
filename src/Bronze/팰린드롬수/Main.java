package Bronze.팰린드롬수;

import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s = br.readLine();
			if(s.equals("0")) break;
			int count = 0;
			for(int i=0; i<s.length()/2; i++) {
				if(s.charAt(i) != s.charAt(s.length()-i-1)){
					count++;
					break;
				}
			}
			if(count>0) System.out.println("no");
			else System.out.println("yes");
		}
	}
}

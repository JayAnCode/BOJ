package Gold.좋은수열;

import java.io.*;
import java.util.ArrayList;

public class Main {
	static int N;
	static boolean flag;
	static ArrayList<String> list = new ArrayList<>();
	static StringBuilder sb;

	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		go("1");
		br.close();
	}

	public static void go(String s) {
		if(s.length() == N) {
			System.out.println(s);
			System.exit(0);
		}

		for(int i=1; i<=3; i++) {
			sb = new StringBuilder(s);
			flag = true;

			if(s.charAt(s.length()-1)-'0' == i) continue;

			sb.append(i);
			for(int j=1; j<=sb.length()/2; j++) {
				if(sb.substring(sb.length()-j).equals(sb.substring(sb.length()-j*2, sb.length()-j))) {
					flag = false;
				}
			}

			if(flag) go(sb.toString());
		}
	}
}

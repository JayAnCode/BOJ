package Gold.제로_만들기;

import java.io.*;
import java.util.*;

public class Main {
	static int T, N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			N = Integer.parseInt(br.readLine());

			go("1", 2);

			sb.append("\n");
		}

		System.out.print(sb.toString());
		br.close();
	}
	public static void go(String s, int idx) {
		if(idx == N+1) {
			if(check(s)) sb.append(s + "\n");
			return;
		}

		go(s + " " + idx, idx+1);
		go(s + "+" + idx, idx+1);
		go(s + "-" + idx, idx+1);

	}
	public static boolean check(String s) {
		LinkedList<Integer> list = new LinkedList<>();
		ArrayList<Character> sign = new ArrayList<>();

		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == ' ') {
				int x = list.remove(list.size()-1);
				list.add(x*10 + (s.charAt(i+1)-'0'));
				i++;
			}
			else if(s.charAt(i) == '+' || s.charAt(i) == '-') {
				sign.add(s.charAt(i));
			}
			else {
				list.add(s.charAt(i)-'0');
			}
		}

		for(char c : sign) {
			if(c == '+') {
				int x = list.remove(0) + list.remove(0);
				list.add(0, x);
			}
			else {
				int x = list.remove(0) - list.remove(0);
				list.add(0, x);
			}
		}

		if(list.remove() == 0) return true;
		else return false;
	}
}

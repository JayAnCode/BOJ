package Silver.키로커;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String ans[] = new String[N];
		for(int i=0; i<N; i++) {
			LinkedList<Character> list = new LinkedList<>();
			String s = br.readLine();
			int cursor = 0;
			for(int j=0; j<s.length(); j++) {
				if(s.charAt(j) == '<') {
					if(cursor > 0) cursor--;
				}
				else if(s.charAt(j) == '>') {
					if(cursor < list.size()) cursor++;
				}
				else if(s.charAt(j) == '-') {
					if(list.size()>0&&cursor>0) {
						list.remove(cursor-1);
						cursor--;
					}
				}
				else {
					list.add(cursor, s.charAt(j));
					if(cursor < list.size()) cursor++;
				}
			}
			ans[i] = list.stream()
					.map(n -> String.valueOf(n))
					.collect(Collectors.joining());
		}
		for(int i=0; i<N; i++) System.out.println(ans[i]);
		br.close();
	}
}

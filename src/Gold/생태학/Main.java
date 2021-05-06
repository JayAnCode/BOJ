package Gold.생태학;

import java.io.*;
import java.util.TreeMap;

public class Main {
	static int count;
	static String s;
	static TreeMap<String, Integer> tree = new TreeMap<>();
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		s = br.readLine();

		if(s == null) return;

		while(s != null && !s.equals("")) {
			tree.put(s, tree.getOrDefault(s, 0) + 1);
			count += 1;
			s = br.readLine();
		}

		for(String str : tree.keySet()) {
			String per = String.format("%.4f", (double)tree.get(str)/count*100);
			sb.append(str + " " + per + "\n");
		}

		System.out.print(sb.toString());
		br.close();
	}
}

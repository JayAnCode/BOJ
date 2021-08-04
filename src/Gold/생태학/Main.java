package Gold.생태학;

import java.io.*;
import java.util.TreeMap;

public class Main {
	static int count;
	static String s;
	static TreeMap<String, Integer> tree = new TreeMap<>();	// KEY를 이름순으로 저장하기 위해 TrreMap 사용

	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		s = br.readLine();

		if(s == null) return;

		while(s != null && !s.equals("")) {
			tree.put(s, tree.getOrDefault(s, 0) + 1);	// TrreMap을 활용해 각 종의 갯수를  카운트
			count += 1;	// 전체 갯수 카운트
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

package Silver.나이순_정렬;

import java.io.*;
import java.util.*;

public class Main {
	public static class Pair {
		int age;
		String name;
		public Pair(int age, String name) {
			this.age = age;
			this.name = name;
		}
	}
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		List<Pair> list = new LinkedList<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br. readLine(), " ");
			list.add(new Pair(Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		Collections.sort(list, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				if(o1.age == o2.age) return o1.name.compareTo(o2.name);
				else return o1.age-o2.age;
			}
		});
		for(int i=0; i<n; i++) {
			bw.write(list.get(i).age + " " + list.get(i).name);
			bw.flush();
			bw.newLine();
		}
		br.close();
		bw.close();
	}
}

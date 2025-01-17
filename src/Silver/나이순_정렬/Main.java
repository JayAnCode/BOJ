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
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Pair[] p = new Pair[n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br. readLine(), " ");
			p[i] = new Pair(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		Arrays.sort(p, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.age - o2.age;
			}
		});
		for(int i=0; i<n; i++) {
			sb.append(p[i].age + " " + p[i].name + "\n");
		}
		System.out.println(sb);
	}
}

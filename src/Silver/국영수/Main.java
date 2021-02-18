package Silver.국영수;

import java.io.*;
import java.util.*;

public class Main {
	public static class Pair {
		String name;
		int a;
		int b;
		int c;
		public Pair(String name, int a, int b, int c) {
			this.name = name;
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	public static void main(String[] arg) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Pair[] p = new Pair[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			p[i] = new Pair(st.nextToken(), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(p, new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				if(p1.a == p2.a) {
					if(p1.b == p2.b) {
						if(p1.c == p2.c) return p1.name.compareTo(p2.name);
						else return p2.c-p1.c;
					} else return p1.b-p2.b;
				} else return p2.a-p1.a;
			}});
		for(int i=0; i<N; i++) System.out.println(p[i].name);
		br.close();
	}
}
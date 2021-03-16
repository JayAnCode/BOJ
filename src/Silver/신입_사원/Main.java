package Silver.신입_사원;

import java.io.*;
import java.util.*;

public class Main {
	public static class Pair {
		int a;
		int b;
		public Pair(int a, int b) {
			this.a = a;	this.b =b;
		}
	}
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			Pair p[] = new Pair[N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				p[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			Arrays.sort(p, new Comparator<Pair>() {
				@Override
				public int compare(Pair p1, Pair p2) {
					return p1.a - p2.a;
				}});
			int count = 1;
			int min = p[0].b;
			for(int i=1; i<N; i++) {
				if(min>p[i].b) {
					min = p[i].b;
					count++;
				}
			}
			System.out.println(count);
		}
		br.close();
	}
}

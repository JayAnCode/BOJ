package Silver.좌표_정렬하기;

import java.io.*;
import java.util.*;

public class Main {
	public static class Pair {

		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Pair> list = new ArrayList<>();
		for (int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			list.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list, new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				if (p1.x == p2.x) return p1.y - p2.y;
				else return p1.x - p2.x;
			}
		});
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).x + " " + list.get(i).y);
		}
	}
}
package Gold.이차원_배열과_연산;

import java.io.*;
import java.util.*;

public class Main {
	static int r, c, k, rSize, cSize, count;
	static int arr[][];
	static class Pair {
		int num;
		int cnt;
		public Pair(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st= new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[100][100];
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		count = 0; rSize = 3; cSize = 3;
		while(true) {
			if(arr[r-1][c-1] == k || count > 100) break;

			if(rSize >= cSize) rowCalc();
			else colCalc();

			count++;
		}

		if(count > 100) System.out.println(-1);
		else System.out.println(count);
		br.close();
	}

	public static void rowCalc() {
		int max = 0;
		for(int i=0; i<rSize; i++) {
			ArrayList<Pair> list = new ArrayList<>();
			HashMap<Integer, Integer> hm = new HashMap<>();

			for(int j=0; j<cSize; j++) {
				if(arr[i][j] == 0) continue;
				hm.put(arr[i][j], hm.getOrDefault(arr[i][j], 0) + 1);
			}

			for(int key : hm.keySet()) {
				list.add(new Pair(key, hm.get(key)));
			}

			Collections.sort(list, new Comparator<Pair>() {
				@Override
				public int compare(Pair p1, Pair p2) {
					if(p1.cnt == p2.cnt) return p1.num-p2.num;
					else return p1.cnt-p2.cnt;
				}});

			for(int j=0; j<list.size(); j++) {
				if(j >= 50) break;
				arr[i][j*2] = list.get(j).num;
				arr[i][j*2+1] = list.get(j).cnt;
			}

			int idx = list.size()*2;
			while(true) {
				if(idx >= 100) break;

				arr[i][idx] = 0;
				idx++;
			}

			max = Math.max(max, list.size()*2);

			if(max >= 100) max = 100;
		}

		cSize = max;
	}
	public static void colCalc() {
		int max = 0;
		for(int i=0; i<cSize; i++) {
			ArrayList<Pair> list = new ArrayList<>();
			HashMap<Integer, Integer> hm = new HashMap<>();

			for(int j=0; j<rSize; j++) {
				if(arr[j][i] == 0) continue;
				hm.put(arr[j][i], hm.getOrDefault(arr[j][i], 0) + 1);
			}

			for(int key : hm.keySet()) {
				list.add(new Pair(key, hm.get(key)));
			}

			Collections.sort(list, new Comparator<Pair>() {
				@Override
				public int compare(Pair p1, Pair p2) {
					if(p1.cnt == p2.cnt) return p1.num-p2.num;
					else return p1.cnt-p2.cnt;
				}});

			for(int j=0; j<list.size(); j++) {
				if(j >= 50) break;
				arr[j*2][i] = list.get(j).num;
				arr[j*2+1][i] = list.get(j).cnt;
			}

			int idx = list.size()*2;
			while(true) {
				if(idx >= 100) break;

				arr[idx][i] = 0;
				idx++;
			}

			max = Math.max(max, list.size()*2);
			if(max >= 100) max = 100;
		}

		rSize = max;
	}
}
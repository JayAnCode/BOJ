package Gold.치킨_배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N, M, sum, ans;
	static int map[][];
	static ArrayList<Pair> house;
	static ArrayList<Pair> chicken;
	static Stack<Pair> stack;
	static class Pair {
		int row;
		int col;
		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N+1][N+1];
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) house.add(new Pair(i, j));
				else if(map[i][j] == 2) chicken.add(new Pair(i, j));
			}
		}

		stack = new Stack<>();
		ans = Integer.MAX_VALUE;
		go(0, 0);
		System.out.println(ans);
		br.close();
	}
	public static void go(int start, int count) {
		if(count == M) {
			sum = 0;
			for (Pair p1 : house) {
				int min = Integer.MAX_VALUE;
				for (Pair p2 : stack) min = Math.min(min, Math.abs(p1.col - p2.col) + Math.abs(p1.row - p2.row));
				sum += min;

				if (sum > ans) break;
			}

			ans = Math.min(ans, sum);
			return;
		}

		for(int i = start; i<chicken.size(); i++) {
			stack.push(chicken.get(i));
			go(i+1, count+1);
			stack.pop();
		}
	}
}

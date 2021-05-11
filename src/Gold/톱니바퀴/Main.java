package Gold.톱니바퀴;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int K, num, dir, ans;
	static int gear[][];
	static boolean visited[];
	static int di[] = {-1, 1};
	static int dj[] = {6, 2};

	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		gear = new int[5][8];
		for(int i=1; i<5; i++) {
			String s = br.readLine();
			for(int j=0; j<8; j++) {
				gear[i][j] = s.charAt(j)-'0';
			}
		}

		K = Integer.parseInt(br.readLine());
		while(K-- > 0) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			dir = Integer.parseInt(st.nextToken());

			visited = new boolean[5];
			go(num, dir);
		}

		for(int i=1; i<5; i++) {
			ans += gear[i][0] * Math.pow(2, i-1);
		}

		System.out.println(ans);
		br.close();
	}

	public static void go(int num, int dir) {
		visited[num] = true;

		for(int i=0; i<2; i++) {
			int ni = num + di[i];

			if(ni < 1 || ni > 4) continue;
			if(visited[ni]) continue;

			if(gear[num][dj[i]] != gear[ni][dj[1-i]]) {
				go(ni, -dir);
			}
		}

		if(dir == 1) rotation(num);
		else reverseRotation(num);
	}

	public static void rotation(int num) {
		int temp = gear[num][7];

		for(int i=7; i>0; i--) {
			gear[num][i] = gear[num][i-1];
		}

		gear[num][0] = temp;
	}
	public static void reverseRotation(int num) {
		int temp = gear[num][0];

		for(int i=0; i<7; i++) {
			gear[num][i] = gear[num][i+1];
		}

		gear[num][7] = temp;
	}
}

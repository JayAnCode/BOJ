package Gold.미친_로봇;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static double sum;
	static boolean check[][] = new boolean[30][30];
	static double per[] = new double[4];
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		for(int i=0; i<4; i++) per[i] = Double.parseDouble(st.nextToken())*0.01;

		sum = 0;
		check[15][15] = true;
		go(15, 15, 1.d, 0);

		System.out.println(sum);
		br.close();
	}
	public static void go(int row, int col, double mul, int count) {
		if(count == N) {
		 	sum += mul;
			return;
		}

		for(int i=0; i<4; i++) {
			int nx = col + dx[i];
			int ny = row + dy[i];

			if(!check[ny][nx] && per[i] > 0) {
				check[row][col] = true;
				go(ny, nx, mul*per[i], count+1);
				check[ny][nx] = false;
			}
		}
	}
}

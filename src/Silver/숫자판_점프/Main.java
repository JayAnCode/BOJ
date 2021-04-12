package Silver.숫자판_점프;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int map[][] = new int[5][5];
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static HashSet<String> set = new HashSet<>();
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				dfs(i, j, "");
			}
		}

		System.out.println(set.size());
		br.close();
	}
	public static void dfs(int row, int col, String s) {
		if(s.length() == 6) {
			set.add(s);
			return;
		}

		for(int i=0; i<4; i++) {
			int nx = col + dx[i];
			int ny = row + dy[i];

			if((nx>=0 & nx<5) && (ny>=0 && ny<5)) {
				dfs(ny, nx, s+map[ny][nx]);
			}
		}
	}
}

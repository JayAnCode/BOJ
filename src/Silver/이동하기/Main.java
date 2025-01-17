package Silver.이동하기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int map[][] = new int[N+1][M+1];
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<M+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=1; i<N+1; i++) {
			for(int j=1; j<M+1; j++) {
				map[i][j] += Math.max(map[i-1][j-1], Math.max(map[i-1][j], map[i][j-1]));
			}
		}

		System.out.println(map[N][M]);
		br.close();
	}
}

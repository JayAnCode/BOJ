package Silver.안전_영역;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static int N, minH, maxH, count, maxNum;
	static int map[][];
	static boolean visited[][];
	static int dx[] = {0, 0, -1, 1};
	static int dy[] = {-1, 1, 0, 0};
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		minH = 100; maxH = 1;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				minH = Math.min(minH, map[i][j]);
				maxH = Math.max(maxH, map[i][j]);
			}
		}
		maxNum = 1;
		for(int k=minH; k<maxH; k++) {
			visited = new boolean[N][N];
			count = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j] && map[i][j]>k) {
						bfs(i, j, k);
						count++;
					}
				}
			}
			maxNum = Math.max(maxNum, count);
		}
		System.out.println(maxNum);
		br.close();
	}
	public static void bfs(int col, int row, int height) {
		visited[col][row] = true;
		for(int i=0; i<4; i++) {
			int ny = col + dy[i];
			int nx = row + dx[i];
			if((ny>=0 && ny<N) && (nx>=0 && nx<N)) {
				if(!visited[ny][nx] && map[ny][nx]>height) {
					bfs(ny, nx, height);
				}
			}
		}
	}
}

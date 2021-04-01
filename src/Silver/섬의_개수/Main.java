package Silver.섬의_개수;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb;
	static int w, h, count;
	static int map[][];
	static boolean visited[][];
	static int dx[] = {0, 0, -1, 1, -1, 1, -1, 1};
	static int dy[] = {-1, 1, 0, 0, -1, -1, 1, 1};
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w==0 && h==0) break;
			map = new int[h][w];
			visited = new boolean[h][w];
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			count = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(!visited[i][j] && map[i][j]==1) {
						dfs(i, j);
						count++;
					}
				}
			}
			sb.append(count+"\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
	public static void dfs(int col, int row) {
		visited[col][row] = true;
		for(int i=0; i<8; i++) {
			int ny = col + dy[i];
			int nx = row + dx[i];
			if((ny>=0 && ny<h) && (nx>=0 && nx<w)) {
				if(!visited[ny][nx] && map[ny][nx]==1) dfs(ny, nx);
			}
		}
	}
}

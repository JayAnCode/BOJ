package Gold.주사위_굴리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, x, y, K, temp;
	static int map[][];
	static int command[];
	static int dx[] = {0, 1, -1, 0, 0};
	static int dy[] = {0, 0, 0, -1, 1};
	static int t, b, w, e, s, n = 0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		command = new int[K];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) command[i] = Integer.parseInt(st.nextToken());

		go(x, y);

		System.out.print(sb.toString());
		br.close();
	}
	public static void go(int x, int y) {
		int nx, ny;
		for(int i=0; i<K; i++) {
			nx = x + dx[command[i]];
			ny = y + dy[command[i]];
			if((nx>=0 && nx<M) && (ny>=0 && ny<N)) {
				move(command[i]);

				if(map[ny][nx] == 0) {
					map[ny][nx] = b;
				}
				else {
					b = map[ny][nx];
					map[ny][nx] = 0;
				}

				sb.append(t+"\n");

				x = nx; y = ny;
			}
		}
	}
	public static void move(int dir) {
		if(dir == 1) {
			temp = t;
			t = w; w = b; b = e;
			e = temp;
		}
		else if(dir == 2) {
			temp = t;
			t = e; e = b; b = w;
			w = temp;
		}
		else if(dir == 3) {
			temp = t;
			t = s; s = b; b = n;
			n = temp;
		}
		else {
			temp = t;
			t = n; n = b; b = s;
			s = temp;
		}
	}
}

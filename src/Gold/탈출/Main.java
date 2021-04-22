package Gold.탈출;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C, count;
	static boolean flag;
	static char map[][];
	static boolean check[][];
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static Queue<Loc> waterLoc, sLoc;

	static class Loc {
		int row;
		int col;
		public Loc(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		check = new boolean[R][C];
		sLoc = new LinkedList<>();
		waterLoc = new LinkedList<>();

		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0; j<C; j++) {
				if(map[i][j] == 'S') sLoc.offer(new Loc(i, j));
				else if(map[i][j] == '*') waterLoc.offer(new Loc(i, j));
			}
		}

		count = 0;
		while(!sLoc.isEmpty()) {
			if(flag) break;
			water();
			go();
			count++;
		}

		if(flag) System.out.println(count);
		else System.out.println("KAKTUS");
		br.close();
	}
	public static void go() {
		int sSize = sLoc.size();
		for(int i=0; i<sSize; i++) {
			Loc s = sLoc.poll();

			for(int j=0; j<4; j++) {
				int nx = s.col + dx[j];
				int ny = s.row + dy[j];

				if ((nx>=0 && nx<C) && (ny>=0 && ny<R)) {
					if(map[ny][nx] == '.') {
						map[ny][nx] = 'S';
						sLoc.offer(new Loc(ny, nx));
					}
					else if(map[ny][nx] == 'D') {
						flag = true;
					}
				}
			}
		}
	}
	public static void water() {
		int wSize = waterLoc.size();
		for(int i=0; i<wSize; i++) {
			Loc w = waterLoc.poll();

			for(int j=0; j<4; j++) {
				int nx = w.col + dx[j];
				int ny = w.row + dy[j];

				if ((nx>=0 && nx<C) && (ny>=0 && ny<R)) {
					if(map[ny][nx] == '.' || map[ny][nx] == 'S') {
						map[ny][nx] = '*';
						waterLoc.offer(new Loc(ny, nx));
					}
				}
			}
		}
	}
}

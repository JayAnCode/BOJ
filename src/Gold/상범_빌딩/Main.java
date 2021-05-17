package Gold.상범_빌딩;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int L, C, R, time;
	static char building[][][];
	static boolean visited[][][];
	static int dl[] = {0, 0, 0, 0, -1, 1};
	static int dr[] = {-1, 1, 0, 0, 0, 0};
	static int dc[] = {0, 0, -1, 1, 0, 0};
	static Loc start;
	static Loc end;

	static class Loc {
		int l, r, c;
		public Loc(int l, int r, int c) {
			this.l = l; this.r = r; this.c = c;
		}
	}
	static class Pair {
		Loc loc;
		int time;
		public Pair(Loc loc, int time) {
			this.loc = loc;
			this.time = time;
		}
	}

	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			if(L ==0 && C == 0 && R == 0) break;

			building = new char[L][R][C];
			for(int i=0; i<L; i++) {
				for(int j=0; j<R; j++) {
					String s = br.readLine();
					for(int k=0; k<C; k++) {
						building[i][j][k] = s.charAt(k);

						if(building[i][j][k] == 'S') start = new Loc(i, j, k);
						if(building[i][j][k] == 'E') end = new Loc(i, j, k);
					}
				}
				String jump = br.readLine();
			}


			visited = new boolean[L][R][C];
			time = 0;
			boolean flag = bfs(start, end, time);

			if(flag) sb.append("Escaped in " + time + " minute(s).\n");
			else sb.append("Trapped!\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	public static boolean bfs(Loc s, Loc e, int t) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(s, t));
		visited[s.l][s.r][s.c] = true;

		while(!q.isEmpty()) {
			Pair p = q.poll();

			if(p.loc.l == e.l && p.loc.r == e.r && p.loc.c == e.c) {
				time = p.time;
				return true;
			}

			for(int i=0; i<6; i++) {
				int nl = p.loc.l + dl[i];
				int nr = p.loc.r + dr[i];
				int nc = p.loc.c + dc[i];

				if((nl < 0 || nl >= L) || (nr < 0 || nr >= R) || (nc < 0 || nc >= C)) continue;

				if(building[nl][nr][nc] != '#' && !visited[nl][nr][nc]) {
					q.offer(new Pair(new Loc(nl, nr, nc), p.time+1));
					visited[nl][nr][nc] = true;
				}
			}

		}

		return false;
	}
}

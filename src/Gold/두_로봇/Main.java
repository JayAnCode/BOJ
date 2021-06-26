package Gold.두_로봇;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, robot1, robot2, ans;
	static ArrayList<Node> list[];
	static boolean visited[];

	static class Node {
		int room;
		int pass;
		public Node(int room, int pass) {
			this.room = room;
			this.pass = pass;
		}
	}	// 연결된 방과 통로의 길이 정보
	static class Loc {
		int cur;
		int len;
		int max;
		public Loc(int cur, int len, int max) {
			this.cur = cur;
			this.len = len;
			this.max = max;
		}
	}	// 현재의 방과 길이의 합, 최대 길이 정보

	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		robot1 = Integer.parseInt(st.nextToken());
		robot2 = Integer.parseInt(st.nextToken());

		list = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}	// 방마다 연결된 방의 갯수가 차이나고 방의 갯수가 최대 10만개이므로 ArrayList를 통해 방의 정보 리스트 구현

		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}

		ans = 0;
		visited = new boolean[N+1];
		bfs(robot1, robot2);	// 로봇1이 로봇2의 위치로 가는 최단 거리 계산

		System.out.println(ans);
		br.close();
	}

	public static void bfs(int start, int end) {
		Queue<Loc> q = new LinkedList<>();
		q.offer(new Loc(start, 0, 0));
		visited[start] = true;

		while(!q.isEmpty()) {
			Loc l = q.poll();

			if(l.cur == end) {
				ans = l.len - l.max;
				break;
			}	// 로봇1이 로봇2의 위치에 도착할 경우 오는 경로 중 가장 긴 통로를 제외하면 두 로봇이 통신을 위한 최소 거리

			for(Node n : list[l.cur]) {
				if(!visited[n.room]) {
					q.offer(new Loc(n.room, l.len+n.pass, Math.max(l.max, n.pass)));
					visited[n.room] = true;
				}
			}
		}
	}
}

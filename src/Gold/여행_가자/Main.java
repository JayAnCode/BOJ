package Gold.여행_가자;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int parent[];
	static boolean flag = true;
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		parent = new int[N+1];
		for(int i=1; i<N+1; i++) {
			parent[i] = i;
		}

		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++) {
				int link = Integer.parseInt(st.nextToken());

				if(link == 1) {
					union(i, j);
				}	// 두 노드가 연결되어 있으면 두 노드 결합하기
			}
		}

		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());	// 시작점
		int idxA = find(a);	// 시작점의 최상위 노드 찾기
		for(int i=0; i<M-1; i++) {
			int b = Integer.parseInt(st.nextToken());	// 다음 방문지
			int idxB = find(b);	// 방문지의 최상위 노드 찾기

			if(idxA != idxB) {
				flag = false;
				break;
			}	// 시작점의 최상위 노드와 방문지의 최상위 노드가 다르면 연결X
		}

		if(flag) System.out.println("YES");
		else System.out.println("NO");

		br.close();
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if(x < y) {
			parent[y] = x;
		}	// y가 크면 y의 상위 노드는 x
		else {
			parent[x] = y;
		}	// x가 크면 x의 상위 노드는 y
	}	// x와 y 결합하기

	public static int find(int x) {
		if(x == parent[x]) {
			return x;
		}

		return parent[x] = find(parent[x]);
	}	// 최상위 노드 찾기
}

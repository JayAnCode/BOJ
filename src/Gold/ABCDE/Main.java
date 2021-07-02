package Gold.ABCDE;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean flag;
	static boolean visited[];
	static ArrayList<Integer> list[];
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N];
		for(int i=0; i<N; i++) list[i] = new ArrayList<>();

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b); list[b].add(a);
		}	//	친구 관계를 ArrayList의 배열 형태로 표현, 관계는 양방향이므로 둘다 추가

		for(int i=0; i<N; i++) {
			if(list[i].size() > 0) {
				visited = new boolean[N];
				visited[i] = true;
				dfs(i, 1);
			}	// 친구가 1명 이상 있으면 친구의 친구 관계를 찾음

			if(flag) break;	//  ABCDE 관계가 1개만 있어도 조건을 만족하므로 for문 종료
		}

		if(flag) System.out.println("1");
		else System.out.println("0");

		br.close();
	}

	public static void dfs(int point, int count) {
		if(count == 5) {
			flag = true;
			return;
		}	// ABCDE 관계가 존재함

		for(int i : list[point]) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i, count+1);
				visited[i] = false;
			}
		}	// 친구의 친구 찾기
	}
}

package Gold.게리멘더링;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, score1, score2, ans;
	static boolean flag;
	static int pop[];
	static ArrayList<Integer> graph[];
	static boolean check[];
	static ArrayList<Integer> group1;
	static ArrayList<Integer> group2;
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		pop = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) {
			pop[i] = Integer.parseInt(st.nextToken());
		}

		graph = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}

		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			for(int j=0; j<a; j++) {
				int b = Integer.parseInt(st.nextToken());
				graph[i].add(b);
			}
		}

		flag = false; ans = Integer.MAX_VALUE;
		check = new boolean[N+1];
		go(1, 0);

		if(flag) System.out.println(ans);
		else System.out.println("-1");
		br.close();
	}

	public static void go(int cur, int count) {
		if(cur == N+1) {

			group1 = new ArrayList<>();
			group2 = new ArrayList<>();
			for(int i=1; i<N+1; i++) {
				if(check[i]) group1.add(i);
				else group2.add(i);
			}

			if(group1.size() == 0) return;
			if(group2.size() == 0) return;

			if(!connect(group1)) return;
			if(!connect(group2)) return;

			flag = true; score1 = 0; score2 = 0;
			for(int i : group1) {
				score1 += pop[i];
			}
			for(int i : group2) {
				score2 += pop[i];
			}

			ans = Math.min(ans, Math.abs(score1-score2));

			return;
		}

		for(int i=cur; i<N+2; i++) {
			check[i] = true;
			go(cur+1, count+1);
			check[i] = false;

			if(i == N) break;
		}
	}

	public static boolean connect(ArrayList<Integer> list) {
		boolean visited[] = new boolean[N+1];
		int count = 0;
		Queue<Integer> q = new LinkedList<>();
		q.offer(list.get(0));
		visited[list.get(0)] = true;

		while(!q.isEmpty()) {
			int x = q.poll();
			count++;
			for(int i : list) {
				if(graph[x].contains(i) && !visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}

		if(count == list.size()) return true;

		return false;
	}
}

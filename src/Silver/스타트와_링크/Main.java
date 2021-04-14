package Silver.스타트와_링크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, scoreS, scoreL, min;
	static int S[][];
	static boolean check[];
	static ArrayList<Integer> teamS;
	static ArrayList<Integer> teamL;
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		S = new int[N+1][N+1];
		check = new boolean[N+1];
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE;
		go(1, 0);

		System.out.println(min);
		br.close();
	}
	public static void go(int cur, int count) {
		if(count == N/2) {
			teamS = new ArrayList<>();
			teamL = new ArrayList<>();
			scoreS = 0;
			scoreL = 0;

			for(int i=1; i<N+1; i++) {
				if(check[i]) teamS.add(i);
				else teamL.add(i);
			}

			for(int i=0; i<N/2-1; i++) {
				for(int j=i+1; j<N/2; j++) {
					scoreS += S[teamS.get(i)][teamS.get(j)] + S[teamS.get(j)][teamS.get(i)];
					scoreL += S[teamL.get(i)][teamL.get(j)] + S[teamL.get(j)][teamL.get(i)];
				}
			}

			min = Math.min(min, Math.abs(scoreS-scoreL));
			return;
		}
		for(int i=cur; i<N+1; i++) {
			check[i] = true;
			go(i+1, count+1);
			check[i] = false;
		}
	}
}

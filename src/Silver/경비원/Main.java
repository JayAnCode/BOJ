package Silver.경비원;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int w, h, n, sum;
	static Loc loc[];

	static class Loc {
		int x;
		int y;
		public Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		n =Integer.parseInt(br.readLine());

		loc = new Loc[n+1];
		for(int i=1; i<n+2; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			if(i == n+1) {
				loc[0] =  (d == 1 ? new Loc(l, 0) : d == 2 ? new Loc(l, h) : d == 3 ? new Loc(0, l) : new Loc(w, l));
			}	// 초기 위치는 0번째 배열에 저장
			else {
				loc[i] =  (d == 1 ? new Loc(l, 0) : d == 2 ? new Loc(l, h) : d == 3 ? new Loc(0, l) : new Loc(w, l));
			}	// 순서대로 방문할 위치를 배열에 저장
		}

		sum = 0;	// 거리 합계
		calcMinLen();	// 최단 거리 계산하기

		System.out.println(sum);
		br.close();
	}

	public static void calcMinLen() {
		int initX = loc[0].x; int initY = loc[0].y;	// 초기 위치

		for(int i=1; i<n+1; i++) {
			int nextX = loc[i].x; int nextY = loc[i].y;	// 방문할 위치

			if(Math.abs(initX - nextX) == w) {
				sum += Math.min(initY + nextY, 2*h - (initY + nextY)) + w;
			}	// 서로 반대 위치일 때(북 - 남)
			else if(Math.abs(initY - nextY) == h) {
				sum += Math.min(initX + nextX, 2*w - (initX + nextX)) + h;
			}	// 서로 반대 위치일 때(서 - 동)
			else {
				sum += Math.abs(initX - nextX) + Math.abs(initY - nextY);
			}
		}
	}
}

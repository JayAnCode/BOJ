package Silver.연산자_끼워넣기;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, max, min;
	static int seq[];
	static int op[] = new int[4];
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		seq = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) seq[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) op[i] = Integer.parseInt(st.nextToken());
		max = Integer.MIN_VALUE; min = Integer.MAX_VALUE;
		go(1, seq[0]);
		System.out.println(max);
		System.out.println(min);
		br.close();
	}
	public static void go(int idx, int sum) {
		if(idx == N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
		}
		for(int i=0; i<4; i++) {
			if(op[i] != 0) {
				op[i] -= 1;
				if(i == 0) go(idx+1, sum + seq[idx]);
				else if(i == 1) go(idx+1, sum - seq[idx]);
				else if(i == 2) go(idx+1, sum * seq[idx]);
				else go(idx+1, sum / seq[idx]);
				op[i] += 1;
			}
		}
	}
}

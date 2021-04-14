package Silver.컨베이어_벨트_위의_로봇;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K, temp, count, ans;
	static int belt[];
	static boolean robot[];
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		belt = new int[2*N];
		robot = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<2*N; i++) belt[i] = Integer.parseInt(st.nextToken());

		go(0);

		System.out.println(ans);
		br.close();
	}
	public static void go(int cur) {
		if(count >= K) {
			ans = cur;
			return;
		}

		//step1
		temp = belt[2*N-1];
		for(int i=2*N-1; i>0; i--) belt[i] = belt[i-1];
		belt[0] = temp;
		for(int i=N-1; i>0; i--) robot[i] = robot[i-1];
		robot[0] = false;

		//step2
		if(robot[N-2] && belt[N-1]>0) {
			robot[N-1] = true;
			robot[N-2] = false;
			belt[N-1]--;
		}
		for (int i = N-2; i>0; i--) {
			if (robot[i-1] && !robot[i] && belt[i]>0) {
				robot[i] = true;
				robot[i-1] = false;
				belt[i]--;
			}
		}

		//step3
		if(!robot[0] && belt[0]>0) {
			robot[0] = true;
			belt[0]--;
		}

		//step4
		count = 0;
		for(int i=0; i<2*N; i++) {
			if(belt[i] == 0) count++;
		}

		go(cur+1);
		return;
	}
}

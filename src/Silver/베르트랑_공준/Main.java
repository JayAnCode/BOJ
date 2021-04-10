package Silver.베르트랑_공준;

import java.io.*;
import java.util.Arrays;

public class Main {
	static boolean prime[] = new boolean[2*123456+1];

	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		for(int i=2; i<=Math.sqrt(prime.length); i++) {
			if(prime[i]) {
				for(int j = i+1; j<prime.length; j++) {
					if(j%i == 0) prime[j] = false;
				}
			}
		}

		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;

			int count = N;
			for(int i=N+1; i<=2*N; i++) {
				if(!prime[i]) count -= 1;
			}

			sb.append(count + "\n");
		}

		System.out.print(sb.toString());
		br.close();
	}
}

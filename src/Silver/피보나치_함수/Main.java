package Silver.피보나치_함수;

import java.io.*;

public class Main {
	static int zero, one, temp;
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			zero = 1; one = 0;
			temp = zero + one;
			for (int i=0; i<N; i++) {
				zero = one;
				one = temp;
				temp = zero + one;
			}
			System.out.println(zero + " " + one);
		}
		br.close();
	}
}
package Silver.이항_계수2;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		BigInteger bi = BigInteger.ONE;
		for(int i=N; i>N-K; i--) {
			bi =  bi.multiply(BigInteger.valueOf(i));
		}
		for(int i=1; i<=K; i++) {
			bi = bi.divide(BigInteger.valueOf(i));
		}

		System.out.println(bi.remainder(BigInteger.valueOf(10007)));
		br.close();
	}
}

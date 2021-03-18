package Gold.합분해;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		BigInteger ans = BigInteger.ONE;
		for(int i=1; i<K; i++) ans = ans.multiply(BigInteger.valueOf(N+K-i));
		for(int i=1; i<K; i++) ans = ans.divide(BigInteger.valueOf(i));
		ans = ans.remainder(BigInteger.valueOf(1000000000));
		System.out.println(ans.intValue());
		br.close();
	}
}

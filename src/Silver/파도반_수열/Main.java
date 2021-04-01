package Silver.파도반_수열;

import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		BigInteger num[] = new BigInteger[101];
		num[1] = BigInteger.valueOf(1);
		num[2] = BigInteger.valueOf(1);
		num[3] = BigInteger.valueOf(1);
		for(int i=4; i<101; i++) num[i] = num[i-2].add(num[i-3]);
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			sb.append(num[Integer.parseInt(br.readLine())]+"\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}

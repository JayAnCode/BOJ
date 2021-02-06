package Silver.로프;

import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num[] = new int[N];
		for(int i=0; i<N; i++) num[i] = Integer.parseInt(br.readLine());
		Arrays.sort(num);
		int max = 0;
		for(int i=0; i<N; i++) max = Math.max((N-i)*num[i], max);
		System.out.println(max);
		br.close();
	}
}

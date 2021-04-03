package Silver.토너먼트;

import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int a  = Integer.parseInt(st.nextToken());
		int b  = Integer.parseInt(st.nextToken());
		int count = 0;
		while(true) {
			if(a==b) break;
			a = a/2 + a%2;
			b = b/2 + b%2;
			count++;
		}
		System.out.println(count);
		br.close();
	}
}

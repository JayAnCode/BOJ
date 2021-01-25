package Bronze.진법변환2;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger n = new BigInteger(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		System.out.println(n.toString(b).toUpperCase());
	}
}

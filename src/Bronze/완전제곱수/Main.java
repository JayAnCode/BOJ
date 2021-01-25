package Bronze.완전제곱수;

import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int a = (int)Math.ceil(Math.sqrt(m));
		int b = (int)Math.floor(Math.sqrt(n));
		if(a>b) System.out.println(-1);
		else {
			int sum = 0;
			for(int i=a; i<=b; i++) sum += i*i;
			System.out.println(sum);
			System.out.println(a*a);
		}
	}
}

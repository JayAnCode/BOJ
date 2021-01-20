package Bronze.분산처리;

import java.util.*;

public class Main {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n-->0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int res = a;
			for(int i=1; i<b; i++) res = (res*a)%10;
			if(b == 1) res = a%10;
			if(res == 0) System.out.println(10);
			else System.out.println(res);
		}
	}
}

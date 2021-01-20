package Bronze.핸드폰요금;

import java.util.*;

public class Main {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum1 = 0;
		int sum2 = 0;
		for(int i=0; i<n; i++) {
			int time = sc.nextInt();
			sum1 += (time/30 + 1)*10;
			sum2 += (time/60 + 1)*15;
		}
		if(sum1<sum2) System.out.println("Y " + sum1);
		else if(sum1>sum2) System.out.println("M " + sum2);
		else System.out.println("Y " + "M " + sum1);
	}
}
package Bronze.부호;

import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int count = 3;
		while(count-->0) {
			int n = sc.nextInt();
			BigInteger sum = new BigInteger("0");
			for(int i=0; i<n; i++) {
				long l = sc.nextLong();
				sum = sum.add(BigInteger.valueOf(l));
			}
			if(sum.compareTo(BigInteger.valueOf(0))>0) System.out.println("+");
			else if(sum.compareTo(BigInteger.valueOf(0))<0) System.out.println("-");
			else System.out.println("0");
		}
	}
}
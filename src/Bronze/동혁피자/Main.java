package Bronze.동혁피자;

import java.util.*;

public class Main {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int i = 0;
		while(++i>0) {
			double r = sc.nextDouble();
			if(r == 0) break;
			double w = sc.nextDouble();
			double l = sc.nextDouble();
			double diameter = 2*r;
			double diagonal = Math.pow(w*w + l*l,0.5);

			if(diameter >= diagonal) System.out.println("Pizza " + i + " fits on the table.");
			else System.out.println("Pizza " + i + " does not fit on the table.");
		}
	}
}

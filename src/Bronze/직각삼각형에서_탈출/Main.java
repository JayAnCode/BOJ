package Bronze.직각삼각형에서_탈출;

import java.util.*;

public class Main {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		int min = Math.min(x,Math.min(w-x, Math.min(y, h-y)));
		System.out.println(min);
	}
}

package Bronze.바구니뒤집기;

import java.util.*;

public class Main {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int num[] = new int[n];
		for(int i=0; i<n; i++) num[i] = i+1;

		while(m-->0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			List<Integer> list = new LinkedList<>();
			for(int i=a-1; i<b; i++) list.add(num[i]);
			Collections.reverse(list);
			for(int i=a-1; i<b; i++) num[i] = list.remove(0);
		}

		for(int i=0; i<n-1; i++) System.out.print(num[i] + " ");
		System.out.println(num[n-1]);
	}
}
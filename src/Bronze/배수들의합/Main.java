package Bronze.배수들의합;

import java.util.*;

public class Main {
	public static void main(String args[]) {

		HashSet<Integer> set = new HashSet<>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		for(int i=0; i<m; i++) {
			int num = sc.nextInt();
			for(int j=1; num*j<=n; j++) {
				set.add(num*j);
			}
		}
		int ans = 0;
		Iterator it= set.iterator();
		while(it.hasNext()) {
			ans += (int) it.next();
		}
		System.out.println(ans);
	}
}

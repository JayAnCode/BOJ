package Bronze.부재중전화;

import java.util.*;

public class Main {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		int d = sc.nextInt();
		int ans = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<n; i++){
			for(int j=0; j<l; j++){
				list.add(0);
			}
			for(int j=0; j<5; j++){
				list.add(1);
			}
		}
		while(true){
			if(ans>=list.size()) break;
			if(list.get(ans) == 1) break;
			else ans += d;
		}
		System.out.println(ans);
	}
}


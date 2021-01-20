package Bronze.대표값;

import java.util.*;

public class Main {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		HashMap<Integer,Integer> map = new HashMap<>();
		int mean = 0;
		int mode = 0;
		for(int i=0; i<10; i++) {
			int num = sc.nextInt();
			map.put(num, map.getOrDefault(num, 0)+1);
			mean += num/10;
		}
		int max = 0;
		for(int i: map.keySet()) {
			if(map.get(i) > max) {
				max = map.get(i);
				mode = i;
			}
		}
		System.out.println(mean);
		System.out.println(mode);
	}
}
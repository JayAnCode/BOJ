package Silver.부등호;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int k;
	static String max, min;
	static boolean check[];
	static char sign[];
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());

		sign = new char[k];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<k; i++) sign[i] = st.nextToken().charAt(0);

		check = new boolean[10];
		max = String.valueOf(Long.MIN_VALUE);
		min = String.valueOf(Long.MAX_VALUE);
		go("", 0);

		System.out.println(max);
		System.out.println(min);
		br.close();
	}
	public static void go(String num, int index) {
		if(index == k+1) {
			if(max.compareTo(num) < 0) max = num;
			if(min.compareTo(num) > 0) min = num;
			return;
		}

		for(int i=0; i<10; i++) {
			if(check[i]) continue;
			if(flag(num, index, i)) {
				check[i] = true;
				go(num+i, index+1);
				check[i] = false;
			}
		}
	}
	public static boolean flag(String num, int index, int i) {
		if(index == 0) return true;
		else if(sign[index-1] == '<' && num.charAt(index-1)-'0' < i) return true;
		else if(sign[index-1] == '>' && num.charAt(index-1)-'0' > i) return true;

		return false;
	}
}

package Silver.셀프_넘버;

import java.util.Arrays;

public class Main {
	public static void main(String arg[]) {
		StringBuilder sb = new StringBuilder();
		boolean selfNumber[] = new boolean[10001];
		boolean visited[] = new boolean[10001];
		Arrays.fill(selfNumber, true);
		String s; int num;
		for(int i=1; i<10001 ; i++) {
			if(visited[i]) continue;
			num = i;
			while(true) {
				visited[num] = true;
				s = String.valueOf(num);
				for(int k=0; k<s.length(); k++) {
					num += s.charAt(k)-'0';
				}
				if(num<10001) selfNumber[num] = false;
				else break;
			}
		}
		for(int i=1; i<10001; i++) {
			if(selfNumber[i]) sb.append(i+"\n");
		}
		System.out.println(sb.toString());
	}
}

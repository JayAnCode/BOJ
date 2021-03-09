package Silver.문자열_집합;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String s[] = new String[N];
		for(int i=0; i<N; i++) s[i] = br.readLine();
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				if(s[j].equals(str) == true) {
					ans++;
					break;
				}
			}
		}
		System.out.println(ans);
		br.close();
	}
}

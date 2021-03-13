package Silver.골드바흐의_추측;

import java.io.*;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int n = Integer.parseInt(br.readLine());
			int a = n/2;
			int b = n/2;
			while(true) {
				boolean flag_a = true;
				boolean flag_b = true;
				for(int i=2; i<a; i++) {
					if(a%i == 0) {
						flag_a = false;
						break;
					}
				}
				if(flag_a == true) {
					for(int i=2; i<b; i++) {
						if(b%i == 0) {
							flag_b = false;
							break;
						}
					}
				}
				if(flag_a == true && flag_b == true) break;
				else {
					a-=1;
					b+=1;
				}
			}
			System.out.println(a + " " + b);
		}
		br.close();
	}
}

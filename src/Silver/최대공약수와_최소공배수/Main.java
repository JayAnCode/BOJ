package Silver.최대공약수와_최소공배수;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for(int i=Math.min(n,m); i>=1; i--){
			if(m%i==0 && n%i==0){
				System.out.println(i);
				break;
			}
		}
		for(int i=Math.max(n,m); i<=n*m; i++){
			if(i%m==0 && i%n==0){
				System.out.println(i);
				break;
			}
		}
	}
}

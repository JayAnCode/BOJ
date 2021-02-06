package Silver.캠핑;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans;
		for(int i=1; ;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			if(L+P+V == 0) break;
			if(V%P > L) ans = (V/P+1)*L;
			else ans = V/P*L+V%P;
			System.out.println("Case " + i + ": " + ans);
		}
	}
}

package Silver.결혼식;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int n, m, count;
	static int relation[][];
	static boolean visited[];
	static StringTokenizer st;
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		relation = new int[n+1][n+1];
		visited = new boolean[n+1];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			relation[a][b] = relation[b][a] = 1;
		}
		count = 0;
		for(int i=2; i<n+1; i++) {
			if(relation[1][i]==1) {
				if(!visited[i]) {
					visited[i] = true;
					count++;
				}
				for(int j=2; j<n+1; j++) {
					if(!visited[j] && relation[i][j]==1) {
						visited[j] = true;
						count++;
					}
				}
			}
		}
		System.out.println(count);
		br.close();
	}
}

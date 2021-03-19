package Gold.센서;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int sensor[] = new int[N];
		int dist[] = new int[N-1];
		int ans = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) sensor[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(sensor);
		for(int i=0; i<N-1; i++) dist[i] = sensor[i+1]-sensor[i];
		Arrays.sort(dist);
		for(int i=0; i<N-K; i++) ans += dist[i];
		System.out.println(ans);
		br.close();
	}
}

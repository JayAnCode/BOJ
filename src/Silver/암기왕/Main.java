package Silver.암기왕;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(br.readLine());
		while(count-->0) {
			HashSet<Integer> set = new HashSet<>();
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) set.add(Integer.parseInt(st.nextToken()));
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				if(set.contains(Integer.parseInt(st.nextToken()))) bw.write("1\n");
				else bw.write("0\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

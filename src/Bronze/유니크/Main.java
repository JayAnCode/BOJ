package Bronze.유니크;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] num = new int[n][3];
		int[] sum = new int[n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<3; j++) num[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<3; i++) {
			HashMap<Integer, Integer> hm = new HashMap<>();
			for(int j=0; j<n; j++) hm.put(num[j][i], hm.getOrDefault(num[j][i], 0)+1);
			for(int j=0; j<n; j++) {
				if(hm.get(num[j][i])>1) sum[j] += 0;
				else sum[j] += num[j][i];
			}
		}
		for(int i=0; i<n-1; i++) System.out.println(sum[i]);
		System.out.print(sum[n-1]);
	}
}

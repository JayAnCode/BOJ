package Bronze.시험_감독;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int A[] = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		long sum = 0;
		for(int i=0; i<N; i++) {
			sum++;
			if(A[i]<=B) continue;
			if((A[i]-B)%C == 0) sum += (A[i]-B)/C;
			else sum += (A[i]-B)/C + 1;
		}

		System.out.println(sum);
		br.close();
	}
}

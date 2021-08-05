package Silver.수_이어_쓰기_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int num, ans;
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		ans = -1;
		if(getLength(N) >= k) {
			num = 0;
			go(N, k);

			int sumLen = getLength(num);	// num까지의 숫자 길이
			int numLen = String.valueOf(num).length();	// num의 길이

			ans = String.valueOf(num).charAt((k + numLen) - sumLen - 1) - '0';	// k + num의 길이에 num까지의 길이를 뺀 값 k번째 수의 index
		}

		System.out.println(ans);
		br.close();
	}

	public static void go(int N, int k) {	// k번째 숫자를 포함하는 해당하는 값 찾기
		int left = 1; int right = N;
		while(left <= right) {	// 이분 탐색
			int mid = (left + right) / 2;
			int len = getLength(mid);

			if(len < k) {
				left = mid + 1;
			} else {
				num = mid;
				right = mid - 1;
			}
		}
	}

	public static int getLength(int n) {	// 1 ~ n까지 숫자 길이의 합 계산
		int len = 0;

		for(int i=1; i<10; i++) {
			if(Math.pow(10, i) > n) {
				len += (n - Math.pow(10, i-1)) * i + i;
				break;
			}
			else {
				len += 9 * Math.pow(10, i-1) * i;
			}
		}

		return len;
	}
}

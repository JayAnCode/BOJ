package Gold.옥상_정원_꾸미기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long sum = 0;   // 80000*(80000+1)/2는 2^32보다 크므로 long 타입!

		Stack<Integer> stack = new Stack<>();
		stack.push(Integer.parseInt(br.readLine()));

		for(int i=1; i<N; i++) {
			int nextBuilding = Integer.parseInt(br.readLine());

			while(!stack.isEmpty()) {  // 자신보다 큰 빌딩이 오면 살아 남지 못함
				if(stack.peek() <= nextBuilding) {
					stack.pop();
				}
				else break;
			}

			stack.push(nextBuilding);   // 새로운 빌딩 추가

			sum += stack.size()-1;  // 현재 살아남은 빌딩의 수 = 새로 들어온 빌딩까지 볼 수 있는 빌딩들의 수
		}

		System.out.println(sum);
		br.close();
	}
}

package Silver.잃어버린_괄호;

import java.io.*;

public class Main {
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		String str1 = s; String str2 = "";
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '-') {
				str1 = s.substring(0, i);
				str2 = s.substring(i+1);
				break;
			}	// 계산식 중 첫 뺄셈 기호 등장 이후의 모든 숫자들은 전부 빼면 된다.
		}

		int sum = 0;

		String num[] = str1.split("\\+");
		for(int i=0; i<num.length; i++) {
			sum += Integer.parseInt(num[i]);
		}	// 뺄셈 기호 등장 이전의 숫자 처리

		num = str2.split("-|\\+");
		for(int i=0; i<num.length; i++) {
			if(num[i].equals("")) break;	// 뺄셈 기호가 한 번도 등장하지 않은 경우 처리
			sum -= Integer.parseInt(num[i]);
		}	// 뺄셈 기호 등장 이후의 숫자 처리

		System.out.println(sum);
	}
}

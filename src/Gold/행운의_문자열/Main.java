package Gold.행운의_문자열;

import java.io.*;

public class Main {
	static String str;
	static int count;
	static boolean checked[];

	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str = br.readLine();

		count = 0;
		checked = new boolean[str.length()];
		go("");

		calcOverlap();

		System.out.println(count);
		br.close();
	}

	public static void go(String s) {
		if(s.length() == str.length()) {
			if(isLucky(s)) {
				count++;
			}	// 행운의 문자열 조건에 해당되면 count 증가

			return;
		}

		for(int i=0; i<str.length(); i++) {
			if(!checked[i]) {
				if(s.length() > 0 && s.charAt(s.length()-1) == str.charAt(i)) continue;	// 효율성을 위해 이전 문자와 같은 문자가 오는 경우는 패스
				checked[i] = true;
				go(s + str.charAt(i));
				checked[i] = false;
			}
		}	// 모든 문자열 조합을 만들기 위한 반복문 -> 백트래킹
	}

	public static boolean isLucky(String s) {
		for(int i=0; i<s.length()-1; i++) {
			if(s.charAt(i) == s.charAt(i+1)) {
				return false;
			}
		}	// 같은 문자가 연속되면 행운의 문자열의 조건에 만족하지 않으므로 false를 리턴

		return true;
	}

	public static void calcOverlap() {
		int countAlpha[] = new int[26];
		for(int i=0; i<str.length(); i++) {
			countAlpha[str.charAt(i)-'a']++;
		}	// 중복인 알파벳 확인 및 갯수 배열로 저장

		for(int i=0; i<26; i++) {
			if(countAlpha[i] > 1) {
				int num = 1;
				for(int j=1; j<=countAlpha[i]; j++) {
					num *= j;
				}	// 중복되는 알파벳 팩토리얼 계산

				count /= num;	// 총 갯수에서 중복되는 알파벳 팩토리얼만큼 나누어줌
			}
		}
	}
}

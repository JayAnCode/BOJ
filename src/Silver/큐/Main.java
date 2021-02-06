package Silver.큐;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new LinkedList<>();
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			if(s.contains("push")){
				int num = Integer.parseInt(s.substring(5));
				list.add(num);
			}
			else if(s.equals("pop")){
				if(list.size() == 0) System.out.println(-1);
				else System.out.println(list.remove(0));
			}
			else if(s.equals("size")){
				System.out.println(list.size());
			}
			else if(s.equals("empty")){
				if(list.size() == 0) System.out.println(1);
				else System.out.println(0);
			}
			else if(s.equals("front")){
				if(list.size() == 0) System.out.println(-1);
				else System.out.println(list.get(0));
			}
			else if(s.equals("back")){
				if(list.size() == 0) System.out.println(-1);
				else System.out.println(list.get(list.size()-1));
			}
		}
	}
}
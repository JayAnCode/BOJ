package Silver.듣보잡;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		LinkedList<String> list = new LinkedList<>();
		HashMap<String, Integer> map = new HashMap<>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) map.put(br.readLine(), 1);
		for(int i=0; i<M; i++) {
			String s = br.readLine();
			map.put(s, map.getOrDefault(s, 0)+1);
		}
		for(Entry<String, Integer> e : map.entrySet()){
			if(e.getValue() > 1) list.add(e.getKey());
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int i=0; i<list.size(); i++) System.out.println(list.get(i));
		br.close();
	}
}

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.ArrayDeque;

public class Main {
	static String s;
	static int N;
	static int Max;
	static int Min;
	static HashMap<Character, ArrayDeque<Integer>> dict;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		for (int t=0; t<T; t++) {
			s = br.readLine();
			N = Integer.parseInt(br.readLine());
			if (N==1) {
				ans.append("1 1\n");
				continue;
			}
			dict = new HashMap<>();
			Max = 0;
			Min = 1000000000;
			for (int a=0; a<s.length(); a++) {
				if (dict.containsKey(s.charAt(a))) {
					dict.get(s.charAt(a)).add(a);
					if (dict.get(s.charAt(a)).size()==N) {
						int num = dict.get(s.charAt(a)).peekLast() - dict.get(s.charAt(a)).peekFirst() + 1;
						Max = Math.max(Max, num);
						Min = Math.min(Min, num);
						dict.get(s.charAt(a)).pollFirst();
					}
				} else {
					ArrayDeque<Integer> tmp = new ArrayDeque<>();
					tmp.add(a);
					dict.put(s.charAt(a), tmp);
				}
			}
			if (Max==0) {
				ans.append(-1+"\n");
			} else {
				ans.append(Min+" "+Max+"\n");
			}
		}
		System.out.println(ans);	
	}
}

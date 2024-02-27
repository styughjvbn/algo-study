
//02/27(화) - 괄호

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			String str = br.readLine();
			
			Stack<Character> s = new Stack<>();
			boolean check = true;
			
			for(int size = 0; size < str.length(); size++) {
				char temp = str.charAt(size);
				
				if(temp == '(') { s.add(temp); }
				else if(temp == ')') {
					if(s.isEmpty()) {
						check = false;
						break;
					}
					s.pop();
				}
			}
			
			if(!check || s.size() != 0) {sb.append("NO\n");}
			else {sb.append("YES\n");}
		}
		System.out.println(sb);
	}
}

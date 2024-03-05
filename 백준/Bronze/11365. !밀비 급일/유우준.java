
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//03/05(화) - <스터디> !밀비 급일
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		List<String> strs = new ArrayList<>();
		String str = " ";
		while(true) {
			str = br.readLine();
			if(str.equals("END")) {break;}
			strs.add(str);
		}
		
		for(int i = 0; i < strs.size(); i++) {
			StringBuffer sb = new StringBuffer(strs.get(i));
			System.out.println(sb.reverse().toString());
		}
		
//		for(int i = 0; i < strs.size(); i++) {
//			String temp = "";
//			for(int idx = strs.get(i).length() - 1; idx >= 0; idx--) {
//				temp += strs.get(i).charAt(idx);
//			}
//			System.out.println(temp);
//		}
	}
}

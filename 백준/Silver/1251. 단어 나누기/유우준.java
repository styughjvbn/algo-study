import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//02/05(월) - <스터디> 단어 나누기
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<String> res = new LinkedList<>();
		
		String str = br.readLine();
		String temp1 = ""; String temp2 = ""; String temp3 = "";
		for(int i = 1; i < str.length(); i++) {
			for(int j = i + 1; j < str.length(); j++) {
				temp1 = new StringBuilder(str.substring(0, i)).reverse().toString();
				temp2 = new StringBuilder(str.substring(i, j)).reverse().toString();
				temp3 = new StringBuilder(str.substring(j, str.length())).reverse().toString();
				res.add(temp1+temp2+temp3);			
			}
		}
		
		Collections.sort(res);
		System.out.println(res.get(0));
	}
 }

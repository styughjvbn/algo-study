import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		String str = sc.next();
		List<String> li = new ArrayList<>();
		for(int i = 0; i < str.length(); i++) {
			li.add(str.substring(i, str.length()));
		}
		
		Collections.sort(li);
		for(int i = 0; i < li.size(); i++) {
			sb.append(li.get(i)+"\n");
		}
		System.out.println(sb);
		
	}
}

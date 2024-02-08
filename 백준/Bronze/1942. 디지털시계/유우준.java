import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		String str;
		int first; int second;
		for (int i = 0; i < 3; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			first = Integer.parseInt(st.nextToken().replaceAll(":",""));
			second = Integer.parseInt(st.nextToken().replaceAll(":",""));
			
			int cnt = 0;
			
			while(true) {
				if(first % 3 == 0) {cnt++;}
				
				if(first == second) {break;}
				
				first++;
				if(first % 100 == 60) {first += 40;}
				if(first % 10000 == 6000) { first += 4000;} // 위의 if문으로 인해 일,십자리는 0인 경우만 존재
				if(first == 240000) {first = 0;}
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb);		
	}
}

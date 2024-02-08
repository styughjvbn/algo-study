import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int cnt;
	
	
	
	public static void check(int one, int two) {
		while (one<=two) {
			if (one%3==0) {
				cnt+=1;
			}
			one+=1;
			if (one%100==60) {
				one-=60;
				one+=100;
				if ((one%10000)/100==60) {
					one -= 6000;
					one += 10000;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		for (int a=0; a<3; a++) {
			StringTokenizer sen = new StringTokenizer(br.readLine());
			StringTokenizer s = new StringTokenizer(sen.nextToken(), ":");
			int st = Integer.parseInt(s.nextToken())*10000 + Integer.parseInt(s.nextToken())*100 + Integer.parseInt(s.nextToken());
			s = new StringTokenizer(sen.nextToken(), ":");
			int nd = Integer.parseInt(s.nextToken())*10000 + Integer.parseInt(s.nextToken())*100 + Integer.parseInt(s.nextToken());
			cnt = 0;
			if (st>nd) {
				check(st,235959);
				check(0,nd);
			} else {
				check(st,nd);
			}
			ans.append(cnt+"\n");
		}
		System.out.println(ans);
	}
}

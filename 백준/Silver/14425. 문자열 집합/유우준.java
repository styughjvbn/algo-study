import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		String[] s = new String[N];
		String temp = "";
		for(int i = 0; i < N; i++) {
			s[i] = sc.next();
		}
		int cnt = 0;
		for(int i = 0; i < M; i++) {
			temp = sc.next();
			for (int j = 0; j < N; j++) {
				if(temp.equals(s[j])) {
					cnt++;
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}
}

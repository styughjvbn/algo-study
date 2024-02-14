import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] arr = new char[5][15];
		int Max = 0;
		String sen;
		for (int a=0; a<5; a++) {
			sen = br.readLine();
			for (int b=0; b<sen.length(); b++) {
				arr[a][b] = sen.charAt(b);
			}
			Max = Math.max(Max, sen.length());
		}
		StringBuilder ans = new StringBuilder();
		for (int a=0; a<Max; a++) {
			for (int b=0; b<5; b++) {
				if (arr[b][a] == '\0') {
					continue;
				}
				ans.append(arr[b][a]);
			}
		}
		System.out.println(ans);
	}
}

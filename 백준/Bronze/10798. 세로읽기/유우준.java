import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[][] arr = new char[5][62];
		int max_len = Integer.MIN_VALUE;
		for(int i = 0; i < 5; i++) {
			String str = br.readLine();
			for(int j = 0; j < str.length(); j++) {
				arr[i][j] = str.charAt(j);
			}
			
			max_len = Math.max(max_len, str.length());
		}
		
		for(int col = 0; col < max_len; col++) {
			for(int row = 0; row < 5; row++) {
				if(arr[row][col] == '\0') {continue;}
				sb.append(arr[row][col]);
			}
		}
		
		System.out.println(sb);
	}
}

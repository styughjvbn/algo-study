import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[1000001];
		dp[1] = 0; dp[2] = 1; dp[3] = 1;
		for(int i = 4; i <= N; i++) {
			if(i % 3 == 0 && i % 2 == 0) {
				dp[i] = Math.min(dp[i/3], Math.min(dp[i/2], dp[i-1]));
				dp[i] = dp[i] + 1; // 처음에 나누기 3 또는 나누기 2 또는 빼기 1
			}
			else if(i % 3 == 0) {
				dp[i] = Math.min(dp[i/3], dp[i-1]);
				dp[i] = dp[i] + 1; // 처음에 나누기 3
			}
			else if(i % 2 == 0) {
				dp[i] = Math.min(dp[i/2], dp[i-1]);
				dp[i] = dp[i] + 1; // 처음에 나누기 2
			}
			else {
				dp[i] = dp[i - 1] + 1;
			} // 처음에 빼기 1
		}
		System.out.println(dp[N]);
	}
}

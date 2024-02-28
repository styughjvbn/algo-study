import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[][] dp;
	private static int n, k;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dp = new int[n+1][k+1];
		for(int i=0; i<=n; i++) {
			dp[i][1] = 1;
		}
		for(int i=1; i<=k; i++) {
			dp[0][i] = 1;
		}
		for(int i=1; i<=n; i++) {
			for(int j=2; j<=k; j++) {
				dp[i][j] = dp[i][j-1] + dp[i-1][j];
				dp[i][j] %= 1000000000;
			}
		}
		System.out.println(dp[n][k]);
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] wine = new int[n];
		for(int i=0; i<n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		int[] dp = new int[n];
		dp[0] = wine[0];
		if(n>1) dp[1] = wine[0] + wine[1];
		if(n>2) {
			int d = Integer.MIN_VALUE;
			d = Math.max(dp[1], wine[0]+wine[2]);
			dp[2] = Math.max(d, wine[1]+wine[2]);
		}
		for(int i=3; i<n; i++) {
			int case1 = dp[i-3]+wine[i-1]+wine[i];
			int case2 = dp[i-2]+wine[i];
			int case3 = dp[i-1];
			int max = Integer.MIN_VALUE;
			max = Math.max(case1, case2);
			max = Math.max(case3, max);
			dp[i] = max;
		}
		System.out.println(dp[n-1]);
	}
}

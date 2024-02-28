
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int max_sum;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			
			String str = br.readLine();
			st = new StringTokenizer(str);
			int[] dp = new int[N + 1];
			dp[0] = 0;
			for(int idx = 1; idx <= N; idx++) {
				dp[idx] = dp[idx - 1];
				dp[idx] += Integer.parseInt(st.nextToken());
			}
			
			max_sum = Integer.MIN_VALUE;
			sol(dp);
			sb.append(max_sum+"\n");
		}
		System.out.println(sb);
	}

	private static void sol(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				max_sum = Math.max(max_sum, arr[j]-arr[i]);
			}
		}
	}
}

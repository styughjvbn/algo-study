import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] Map;
	static int[][] dp;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Map = new int[N+1][N+1];
		dp = new int[N+1][N+1];
		for (int a=1; a<=N;a ++) {
			StringTokenizer s = new StringTokenizer(br.readLine());
			for (int b=1; b<=N; b++) {
				Map[a][b] =Integer.parseInt(s.nextToken());
			}
		}
		int st = 0;
		int nd = 0;
		for (int a=1; a<=N; a++) {
			for (int b=1; b<=N; b++) {
				if (Map[a][b]==dp[a-1][b]%3) {
					st = dp[a-1][b]+1;
				} else {
					st = dp[a-1][b];
				}
				if (Map[a][b]==dp[a][b-1]%3) {
					nd = dp[a][b-1]+1;
				} else {
					nd = dp[a][b-1];
				}
				dp[a][b] = Math.max(st, nd);
			}
		}
		System.out.println(dp[N][N]);
    }
}

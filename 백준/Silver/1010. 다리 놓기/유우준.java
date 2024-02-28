import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int[][] dp = new int[31][31];
		for(int i = 0; i < 31; i++) {
			for(int j = 0; j <= i; j++) {
				if(i == j || j == 0) { dp[i][j] = 1; }
				else { dp[i][j] = dp[i-1][j-1] + dp[i-1][j]; }
			}
		} // 조합 DP 생성
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {
			String str = br.readLine();
			st = new StringTokenizer(str);
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			// M C N
			sb.append(dp[M][N]+"\n");
		}
		System.out.println(sb);
	}
	
	private static boolean np(int[] arr) {
		int i = M - 1;
		while(i > 0 && arr[i-1] >= arr[i]) {i--;}
		if(i == 0) return false;
		
		int j = M - 1;
		while(arr[i-1] >= arr[j]) {j--;}
		
		swap(arr, i-1, j);
		int k = M - 1;
		while(i < k) { swap(arr,i++,k--); }
		return true;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

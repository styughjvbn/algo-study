import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static class Info {
		int width, length, diagonal; // 가로, 세로, 대각선

		public Info(int width, int length, int diagonal) {
			super();
			this.width = width;
			this.length = length;
			this.diagonal = diagonal;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
	
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N + 1][N + 1];
		Info[][] dp = new Info[N + 1][N + 1];
		for(int i = 0; i < N + 1; i++) {
			for(int j = 0; j < N + 1; j++) {
				dp[i][j] = new Info(0,0,0);
			}
		}
		dp[1][2].width = 1;
			
		for(int row = 1; row <= N; row++) {
			String str = br.readLine();
			st = new StringTokenizer(str);
			for(int col = 1; col <= N; col++) {
				arr[row][col] = Integer.parseInt(st.nextToken());
				if(arr[row][col] == 1) {continue;}
				
				if(row == 1 && col == 2) {continue;}
				
				if(arr[row-1][col] == 0 && arr[row][col-1] == 0) {
					dp[row][col].diagonal = dp[row-1][col-1].width + dp[row-1][col-1].length + dp[row-1][col-1].diagonal;
				} // [row-1][col-1] 위치에 파이프가 있다면 대각선으로 뻗는 파이프 연장 불가(자리 자치 때문)
				dp[row][col].width = dp[row][col-1].width + dp[row][col-1].diagonal;
				dp[row][col].length = dp[row-1][col].length + dp[row-1][col].diagonal;
			}
		}
		
		int res = dp[N][N].width + dp[N][N].length + dp[N][N].diagonal;
		System.out.println(res);
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] dr = {-1, 0, 1, 0}; // 0북 1동 2남 3서
	static int[] dc = {0, 1, 0, -1}; // 0북 1동 2남 3서
	static int cctv_cnt;
	static int min_zero_cnt = Integer.MAX_VALUE;
	
	public static class Info {
		int cctv; int r; int c;
		
		public Info(int cctv, int r, int c) {
			this.cctv = cctv;
			this.r = r;
			this.c = c;
		}		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str = br.readLine();
		st = new StringTokenizer(str);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		Info[] info = new Info[8];
		cctv_cnt = 0;
		for(int row = 0; row < N; row++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			for(int col = 0; col < M; col++) {
				arr[row][col] = Integer.parseInt(st.nextToken());
				if(arr[row][col] != 0 && arr[row][col] != 6) {
					info[cctv_cnt++] = new Info(arr[row][col], row, col);
				}
			}
		} // 1:->, 2:<->, 3:ㄴ, 4:ㅗ, 5:+, 6: 벽 // CCTV끼리는 통과		
//		for(int i = 0; i < cctv_cnt; i++) {
//			System.out.println(info[i].cctv + " " + info[i].r + " " + info[i].c);
//		} // CCTV 종류와 해당 CCTV 위치 좌표(r,c) 테스트 출력
		
		recursion(arr, info, 0);
		System.out.println(min_zero_cnt);
	}

	private static void recursion(int[][] arr, Info[] info, int cnt) {
		if(cnt == cctv_cnt) {
			int zero_cnt = 0;
			for(int row = 0; row < N; row++) {
				for(int col = 0; col < M; col++) {
					if(arr[row][col] == 0) {zero_cnt++;}
				}
			}
			min_zero_cnt = Math.min(min_zero_cnt, zero_cnt);
			return;
		}
		
		int temp[][] = new int[N][M];
		int cctv_num = info[cnt].cctv; int row = info[cnt].r; int col = info[cnt].c;
		if(cctv_num == 1) {
			temp = copyArr(arr);
			upCheck(temp, row, col);
			recursion(temp, info, cnt + 1);
			
			temp = copyArr(arr);
			rightCheck(temp, row, col);
			recursion(temp, info, cnt + 1);
			
			temp = copyArr(arr);
			downCheck(temp, row, col);
			recursion(temp, info, cnt + 1);
			
			temp = copyArr(arr);
			leftCheck(temp, row, col);
			recursion(temp, info, cnt + 1);
		}
		else if(cctv_num == 2) {
			temp = copyArr(arr);
			rightCheck(temp, row, col);
			leftCheck(temp, row, col);
			recursion(temp, info, cnt + 1);
			
			temp = copyArr(arr);
			upCheck(temp, row, col);
			downCheck(temp, row, col);
			recursion(temp, info, cnt + 1);
		}
		else if(cctv_num == 3) {
			temp = copyArr(arr);
			upCheck(temp, row, col);
			rightCheck(temp, row, col);
			recursion(temp, info, cnt + 1);
			
			temp = copyArr(arr);
			rightCheck(temp, row, col);
			downCheck(temp, row, col);
			recursion(temp, info, cnt + 1);
			
			temp = copyArr(arr);
			downCheck(temp, row, col);
			leftCheck(temp, row, col);
			recursion(temp, info, cnt + 1);
			
			temp = copyArr(arr);
			leftCheck(temp, row, col);
			upCheck(temp, row, col);
			recursion(temp, info, cnt + 1);
		}
		else if(cctv_num == 4) {
			temp = copyArr(arr);
			leftCheck(temp, row, col);
			upCheck(temp, row, col);
			rightCheck(temp, row, col);
			recursion(temp, info, cnt + 1);
			
			temp = copyArr(arr);
			upCheck(temp, row, col);
			rightCheck(temp, row, col);
			downCheck(temp, row, col);
			recursion(temp, info, cnt + 1);
			
			temp = copyArr(arr);
			rightCheck(temp, row, col);
			downCheck(temp, row, col);
			leftCheck(temp, row, col);
			recursion(temp, info, cnt + 1);
			
			temp = copyArr(arr);
			downCheck(temp, row, col);
			leftCheck(temp, row, col);
			upCheck(temp, row, col);
			recursion(temp, info, cnt + 1);
		}
		else if(cctv_num == 5) {
			temp = copyArr(arr);
			upCheck(temp, row, col);
			rightCheck(temp, row, col);
			downCheck(temp, row, col);
			leftCheck(temp, row, col);
			recursion(temp, info, cnt + 1);
		}
	}
	
	private static int[][] copyArr(int[][] arr) {
		int[][] temp = new int[N][M];
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < M; col++) {
				temp[row][col] = arr[row][col];
			}
		}
		return temp;
	}

	private static void upCheck(int[][] temp, int r, int c) {
		while(true) {
			int r_ = r + dr[0]; int c_ = c + dc[0];
			if(r_ < 0 || r_ > N - 1 || c_ < 0 || c_ > M - 1) {return;}
			if(temp[r_][c_] == 6) {return;}
		
			temp[r_][c_] = -1;
			
			r = r_; c = c_;
		}
	}
	private static void rightCheck(int[][] temp, int r, int c) {
		while(true) {
			int r_ = r + dr[1]; int c_ = c + dc[1];
			if(r_ < 0 || r_ > N - 1 || c_ < 0 || c_ > M - 1) {return;}
			if(temp[r_][c_] == 6) {return;}
		
			temp[r_][c_] = -1;
			
			r = r_; c = c_;
		}
	}
	private static void downCheck(int[][] temp, int r, int c) {
		while(true) {
			int r_ = r + dr[2]; int c_ = c + dc[2];
			if(r_ < 0 || r_ > N - 1 || c_ < 0 || c_ > M - 1) {return;}
			if(temp[r_][c_] == 6) {return;}
		
			temp[r_][c_] = -1;
			
			r = r_; c = c_;
		}
	}
	private static void leftCheck(int[][] temp, int r, int c) {
		while(true) {
			int r_ = r + dr[3]; int c_ = c + dc[3];
			if(r_ < 0 || r_ > N - 1 || c_ < 0 || c_ > M - 1) {return;}
			if(temp[r_][c_] == 6) {return;}
		
			temp[r_][c_] = -1;
			
			r = r_; c = c_;
		}	
	}	
}

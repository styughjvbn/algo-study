package week6.training;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//02/20(화) - <실습> 적록색약
public class Z02_BJ_10026 {
	static char[][] arr;
	static boolean[][] visited;
	static int N;
	static int[] dr = {0,0,1,-1}; // 동서남북
	static int[] dc = {1,-1,0,0}; // 동서남북	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		visited = new boolean[N][N];
		for(int row = 0; row < N; row++) {
			String str = br.readLine();
			for(int col = 0; col < N; col++) {
				arr[row][col] = str.charAt(col);
			}
		} // 색상 정보 배열 입력
		List<Character> li = new ArrayList<>();
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < N; col++) {
				if(!visited[row][col]) {
					li.add(arr[row][col]);
					sol(arr[row][col], row, col);
				}
			}
		}
		System.out.print(li.size() + " ");
		
		
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < N; col++) {
				if(arr[row][col] == 'R') {arr[row][col] = 'G';}
			}
		}
		li = new ArrayList<>();
		visited = new boolean[N][N];
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < N; col++) {
				if(!visited[row][col]) {
					li.add(arr[row][col]);
					sol(arr[row][col], row, col);
				}
			}
		}
		System.out.println(li.size());
	}

	private static void sol(char color, int r, int c) {
		char RGB = color;
		visited[r][c] = true;
		
		for(int dir = 0; dir < 4; dir++) {
			int r_ = r + dr[dir]; int c_ = c + dc[dir];
			if(r_ < 0 || r_ > N - 1 || c_ < 0 || c_ > N - 1) {continue;}
			
			if(arr[r_][c_] == RGB && !visited[r_][c_]) {
				sol(RGB, r_, c_);
			}
		}
	}
}















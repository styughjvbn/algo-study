import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int r, c, count=1;
	private static int[][] board;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static boolean[] visited;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		board = new int[r][c];
		visited = new boolean[26];
		for(int i=0; i<r; i++) {
			String s = br.readLine();
			for(int j=0; j<c; j++) {
				board[i][j] = s.charAt(j) - 65;
			}
		}
		check(0, 0, 0);
		System.out.println(count);
	} // end of main

	private static void check(int sr, int sc, int cnt) {
		if(visited[board[sr][sc]]) {
			count = Math.max(count, cnt);
			return;
		} else {
			visited[board[sr][sc]] = true;
			for(int i=0; i<4; i++) {
				int nr = sr + dr[i];
				int nc = sc + dc[i];
				if(0<=nr && nr<r && 0<=nc && nc<c){
					check(nr, nc, cnt+1);
				}
			}
			visited[board[sr][sc]]= false;
		}
	}
} // end of class

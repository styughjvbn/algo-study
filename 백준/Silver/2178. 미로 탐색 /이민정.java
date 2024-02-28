import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	private static int[][] map;
	private static int n, m;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
			}
		}
		bfs(0, 0);
		System.out.println(map[n-1][m-1]);
	}

	private static void bfs(int sr, int sc) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {sr, sc});
		
		while (!q.isEmpty()) {
			int[] v = q.poll();
			int r = v[0];
			int c = v[1];
			for(int i=0; i<4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (0<=nr && nr<n && 0<=nc && nc<m && map[nr][nc]==1) {
					q.offer(new int[] {nr, nc});
					map[nr][nc] = map[r][c] + 1;
				}
			}
		}
	}
}

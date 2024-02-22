import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

	static String map[][], color;
	static int n, count;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		map = new String[n][n];
		visited = new boolean[n][n];
		count = 0;
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j] = String.valueOf(str.charAt(j));
			}
		}
		// 적록색맹이 아닌 사람
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					checked(i, j);
					count++;
				}
			}
		}
		stb.append(count).append(" ");
		// 적록색맹인 사람
		visited = new boolean[n][n];
		count = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) { // G -> R
				if(map[i][j].equals("G")) map[i][j] = "R";
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					checked(i, j);
					count++;
				}
			}
		}
		stb.append(count);
		
		System.out.println(stb);
	} // end of main
	
	
	private static void checked(int r, int c) {
		visited[r][c] = true;
		color = map[r][c];
		
		for(int i=0;i<4;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(0>nr || nr>=n || 0>nc || nc>=n)
				continue;
			if (!visited[nr][nc] && color.equals(map[nr][nc])){
				checked(nr, nc);
			}
		}
	}
} // end of class

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m, r, c, k, map[][], dice[], bottom, nr, nc;
	static int[] dr = {0, 0, 0, -1, 1};
	static int[] dc = {0, 1, -1, 0, 0};
	static StringBuilder stb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		dice = new int[7];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		int[] cmd = new int[k];
		for(int i=0; i<k; i++) {
			cmd[i] = Integer.parseInt(st.nextToken());
		}
		bottom = 1;
		for(int i=0; i<k; i++) {
			nr = r + dr[cmd[i]];
			nc = c + dc[cmd[i]];
			if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
			r = r + dr[cmd[i]];
			c = c + dc[cmd[i]];
			roll(cmd[i], nr, nc);
		}
		System.out.println(stb);
	}

	public static void roll(int cmd, int r, int c) {
		
		int temp = dice[6];
		switch(cmd) {
		case 1:
			dice[6] = dice[3];
			dice[3] = dice[1];
			dice[1] = dice[4];
			dice[4] = temp;
			break;
			
		case 2:
			dice[6] = dice[4];
			dice[4] = dice[1];
			dice[1] = dice[3];
			dice[3] = temp;
			break;
			
		case 3:
			dice[6] = dice[5];
			dice[5] = dice[1];
			dice[1] = dice[2];
			dice[2] = temp;
			break;
			
		case 4:
			dice[6] = dice[2];
			dice[2] = dice[1];
			dice[1] = dice[5];
			dice[5] = temp;
			break;
		}
		
		if (map[r][c] == 0) {
			map[r][c] = dice[6];
		} else {
			dice[6] = map[r][c];
			map[r][c] = 0;
		}
		
		stb.append(dice[1]).append("\n");
	}

}

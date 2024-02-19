import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[][] arr;
	static boolean[] alp;
	static int R, C;
	static int max_cnt;
	static int[] dr = {0,0,1,-1}; // 동서남북
	static int[] dc = {1,-1,0,0}; // 동서남북

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str = br.readLine();
		st = new StringTokenizer(str);
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alp = new boolean[26]; // 알파벳 중복 체크
		arr = new char[R][C]; // 알파벳 보드 정보 입력
		for(int r = 0; r < R; r++) {
			str = br.readLine();
			for(int c = 0; c < C; c++) {
				arr[r][c] = str.charAt(c);
			}
		} // 보드 정보 입력 완료
		
		move(0,0,1);
		System.out.println(max_cnt);
	}

	private static void move(int row, int col, int cnt) {
		//System.out.println("현재 이동한 알파벳 :"+"("+row+","+col+") "+arr[row][col]);
		alp[arr[row][col]-'A'] = true;
		max_cnt = Math.max(max_cnt, cnt);
		
		for(int dir = 0; dir < 4; dir++) {
			int r = row + dr[dir]; int c = col + dc[dir];
			if(r < 0 || r > R - 1 || c < 0 || c > C - 1) {continue;} // 보드판 범위를 벗어나면 스킵
			if(!alp[arr[r][c]-'A']) {
				move(r,c,cnt + 1);
				alp[arr[r][c]-'A'] = false; // 탐색 취소 시, 원상복구
			} // 새로 이동한 칸이 기존에 만났던 알파벳과 다를 때만 탐색
		}
	}
}

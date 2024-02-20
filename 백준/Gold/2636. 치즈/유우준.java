import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = {0,0,1,-1}; // 동서남북
	static int[] dc = {1,-1,0,0}; // 동서남북
	static int cheese; // 남은 치즈 갯수
	static int prev_cheese; // 이전(한시간전)에 남아 있던 치즈 개수
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str = br.readLine();
		st = new StringTokenizer(str);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int row = 0; row < N; row++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			for(int col = 0; col < M; col++) {
				arr[row][col] = Integer.parseInt(st.nextToken());
				if(arr[row][col] == 1) {cheese++;}
			}
		} // 사각형 모양의 치즈, 공기 정보 입력 완료
		
		int time = 0;
		while(cheese != 0) {
			visited = new boolean[N][M];
			time++; prev_cheese = cheese;
			check(); // 한 시간 뒤에 녹을 치즈를 반영
		}
		System.out.println(time);
		System.out.println(prev_cheese);
		
	}

	private static void check() {
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < M; col++) {
				if(!visited[row][col]) {
					if(row == 0 || row == N - 1 || col == 0 || col == M - 1) {
						move(row,col);
					} // 격자 테두리만 탐색의 시작점으로 지정
				}
			}
		}
	} // 공기에 접속한 치즈를 2로 바꾸는 함수 -> move 함수로 이어짐

	private static void move(int row, int col) {
		for(int dir = 0; dir < 4; dir++) {
			int r = row + dr[dir]; int c = col + dc[dir];
			if(r < 0 || r > N - 1 || c < 0 || c > M - 1) {continue;}
			
			if(!visited[r][c] && arr[r][c] == 1) {
				visited[r][c] = true;
				arr[r][c] = 0;
				cheese--;
			} // 한시간 뒤 녹을 치즈를 2로 변경
			else if(!visited[r][c]) {
				visited[r][c] = true;
				move(r,c);
			} // 빈공간은 방문처리하고 계속 탐색
		}
	} // 공기에 접속한 치즈를 0으로 녹이고 녹인 치즈 개수를 cheese 변수에 기록하는 함수
}

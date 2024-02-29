import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] arr;
	static int N,M;
	static boolean[][] visited;
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0}; // 동서남북
	static List<int[]> virus;
	static List<int[]> empty;
	static int max_safe = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
	
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		virus = new ArrayList<>();
		empty = new ArrayList<>();		
		for(int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int col = 0; col < M; col++) {
				arr[row][col] = Integer.parseInt(st.nextToken());
				if(arr[row][col] == 2) {
					virus.add(new int[] {row,col});
				} // 바이러스 정보 저장
				else if(arr[row][col] == 0) {
					empty.add(new int[] {row,col});
				} // 안전영역 정보 저장
			}
		} // 영역 정보 입력 완료
		
		int[] p = new int[empty.size()];
		for(int i = 3; i < empty.size(); i++) {
			p[i] = 1;
		}
		
		do {
			visited = new boolean[N][M];
			for(int i = 0; i < empty.size(); i++) {
				if(p[i] == 0) {
					arr[empty.get(i)[0]][empty.get(i)[1]] = 1;
				} // 벽 3개 선택
			}
			
			for(int i = 0; i < virus.size(); i++) {
				DFS(virus.get(i)[0], virus.get(i)[1]);
			}
			
			// 해당 라인에 배열을 탐색하며 안전영역(0) 개수를 세고 최대치 갱신
			count_safe();
					
			for(int i = 0; i < empty.size(); i++) {
				if(p[i] == 0) {
					arr[empty.get(i)[0]][empty.get(i)[1]] = 0;
				} // 벽 3개 취소
			}
		} while(np(p));
		
		System.out.println(max_safe);
	}

	private static void count_safe() {
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == 0 && !visited[i][j]) {cnt++;}
			}
		}
		max_safe = Math.max(max_safe, cnt);
	}

	private static void DFS(int row, int col) {
		for(int dir = 0; dir < 4; dir++) {
			int r = row + dr[dir]; int c = col + dc[dir];
			if(r < 0 || r > N - 1 || c < 0 || c > M - 1) {continue;}
			
			if(visited[r][c]) {continue;} // true인 경우 -> 이미 감염된 경우 패스
			if(arr[r][c] == 2 || arr[r][c] == 1) {continue;} // 다른 바이러스 영역이거나 벽이면 패스
			
			visited[r][c] = true; // 감염 표시
			DFS(r,c);
		}
	}

	private static boolean np(int[] p) {
		int i = empty.size() - 1;
		while(i > 0 && p[i - 1] >= p[i]) {i--;}
		if(i == 0) return false;
		
		int j = empty.size() - 1;
		while(p[i - 1] >= p[j]) {j--;}
		swap(p, i - 1, j);
		
		int k = empty.size() - 1;
		while(i < k) swap(p, i++, k--);
		return true;
		
	}

	private static void swap(int[] p, int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}
}

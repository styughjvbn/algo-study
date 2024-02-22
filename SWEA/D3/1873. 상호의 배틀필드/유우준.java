import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[][] arr;
	static int H;
	static int W;
	static int[] dr = {0,0,1,-1}; // 동서남북
	static int[] dc = {1,-1,0,0}; // 동서남북
	static int tank_r, tank_c, dir; // 초기 전차의 위치 및 바라보는 방향
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String str = br.readLine();
		st = new StringTokenizer(str);
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			arr = new char[H][W];
			for (int row = 0; row < H; row++) {
				str = br.readLine();
				for (int col = 0; col < W; col++) {
					arr[row][col] = str.charAt(col);
					if(arr[row][col] == '^') {
						dir = 3;
						tank_r = row; tank_c = col;
					}
					else if(arr[row][col] == 'v') {
						dir = 2;
						tank_r = row; tank_c = col;
					}
					else if(arr[row][col] == '<') {
						dir = 1;
						tank_r = row; tank_c = col;
					}
					else if(arr[row][col] == '>') {
						dir = 0;
						tank_r = row; tank_c = col;
					}
					
				}
			} // 격자 상태 입력 + 전차 위치 및 방향 저장
			int N = Integer.parseInt(br.readLine());
			str = br.readLine();
			for (int i = 0; i < N; i++) {
				move(str.charAt(i));				
//				for(int row = 0; row < H; row++) {
//					for(int col = 0; col < W; col++) {
//						System.out.print(arr[row][col]);
//					}
//					System.out.println();
//				}
//				System.out.println();			
			} // 명령마다 알맞은 동작 실행
			
			sb.append("#"+test_case+" ");
			for(int row = 0; row < H; row++) {
				for(int col = 0; col < W; col++) {
					sb.append(arr[row][col]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	private static void move(char order) {
		if(order == 'U') {
			moveUp();
		}
		else if(order == 'D') {
			moveDown();
		}
		else if(order == 'L') {
			moveLeft();
		}
		else if(order == 'R') {
			moveRight();
		}
		else if(order == 'S') {
			moveShoot();
		}
	}

	/*
	dr = {0,0,1,-1}; // 0  1 2  3
	dc = {1,-1,0,0}; // 동 서 남 북
	*/
	private static void moveUp() {
		int r = tank_r + dr[3]; int c = tank_c + dc[3];
		if(r < 0 || r > H - 1 || c < 0 || c > W - 1) { dir = 3; arr[tank_r][tank_c] = '^'; } // 격자 밖 - 방향만 변화
		else if(arr[r][c] == '.') {
			dir = 3;
			arr[r][c] = '^'; // 탱크 이동
			arr[tank_r][tank_c] = '.'; // 있었던 자리 평지로
			tank_r = r; tank_c = c; // 탱크 좌표 업데이트
		} // 평지 - 전차를 이동하고 원래 있던 자리를 평지로
		else { dir = 3; arr[tank_r][tank_c] = '^'; } // 벽 또는 물 - 방향만 변화
	}

	private static void moveDown() {
		int r = tank_r + dr[2]; int c = tank_c + dc[2];
		if(r < 0 || r > H - 1 || c < 0 || c > W - 1) { dir = 2; arr[tank_r][tank_c] = 'v'; } // 격자 밖 - 방향만 변화
		else if(arr[r][c] == '.') {
			dir = 2;
			arr[r][c] = 'v'; // 탱크 이동
			arr[tank_r][tank_c] = '.'; // 있었던 자리 평지로
			tank_r = r; tank_c = c; // 탱크 좌표 업데이트
		} // 평지 - 전차를 이동하고 원래 있던 자리를 평지로
		else { dir = 2; arr[tank_r][tank_c] = 'v'; } // 벽 또는 물 - 방향만 변화
	}

	private static void moveLeft() {
		int r = tank_r + dr[1]; int c = tank_c + dc[1];
		if(r < 0 || r > H - 1 || c < 0 || c > W - 1) { dir = 1; arr[tank_r][tank_c] = '<'; } // 격자 밖 - 방향만 변화
		else if(arr[r][c] == '.') {
			dir = 1;
			arr[r][c] = '<'; // 탱크 이동
			arr[tank_r][tank_c] = '.'; // 있었던 자리 평지로
			tank_r = r; tank_c = c; // 탱크 좌표 업데이트
		} // 평지 - 전차를 이동하고 원래 있던 자리를 평지로
		else { dir = 1; arr[tank_r][tank_c] = '<'; } // 벽 또는 물 - 방향만 변화
	}

	private static void moveRight() {
		int r = tank_r + dr[0]; int c = tank_c + dc[0];
		if(r < 0 || r > H - 1 || c < 0 || c > W - 1) { dir = 0; arr[tank_r][tank_c] = '>'; } // 격자 밖 - 방향만 변화
		else if(arr[r][c] == '.') {
			dir = 0;
			arr[r][c] = '>'; // 탱크 이동
			arr[tank_r][tank_c] = '.'; // 있었던 자리 평지로
			tank_r = r; tank_c = c; // 탱크 좌표 업데이트
		} // 평지 - 전차를 이동하고 원래 있던 자리를 평지로
		else { dir = 0; arr[tank_r][tank_c] = '>'; } // 벽 또는 물 - 방향만 변화
	}

	private static void moveShoot() {
		int r = tank_r + dr[dir]; int c = tank_c + dc[dir];
		
		while(true) {
			if(r < 0 || r > H - 1 || c < 0 || c > W - 1) { break; } // 격자 밖 - 무효 포탄
			
			if(arr[r][c] == '*') {
				arr[r][c] = '.';
				break;
			} // 벽돌 벽 - 포탄 소멸, 평지 변화
			else if(arr[r][c] == '#') {
				break;
			} // 강철 벽 - 포탄 소멸, 변화 X
			
			r += dr[dir]; c += dc[dir]; // 포탄 진행 가능 - 다음 칸으로 포탄 이동
		}
	}
}

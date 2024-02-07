import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int N,M,R;
	static int t;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String str = br.readLine();
		st = new StringTokenizer(str);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 배열 생성 및 초기화
		
		str = br.readLine();
		st = new StringTokenizer(str);
		for(int i = 0; i < R; i++) {
			rotate(Integer.parseInt(st.nextToken()));
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb); // 연산 수행 후 배열 출력
	} // end of main

	private static void rotate(int r) {
		if(r == 1) { // 상하반전
			int temp[];
			temp = new int[M];
			for(int row = 0; row < N / 2; row++) { // 절반
				for(int i = 0; i < M; i++) {
					temp[i] = arr[row][i]; 
				} // temp = Arrays.copyOf(arr[row], arr[row].length);
				for(int col = 0; col < M; col++) {
					arr[row][col] = arr[N - 1 - row][col];
					arr[N - 1 - row][col] = temp[col];
				}
			}
		}
		else if(r == 2) { // 좌우반전
			int temp[];
			temp = new int[N];
			for(int col = 0; col < M / 2; col++) { // 절반
				for(int i = 0; i < N; i++) {
					temp[i] = arr[i][col];
				}
				for(int row = 0; row < N; row++) {
					arr[row][col] = arr[row][M - 1 - col];
					arr[row][M - 1 - col] = temp[row];
				}
			}
		}
		else if(r == 3) { // 오른쪽 90도 회전 -> 문제
			int temp2[][];
			temp2 = new int[N][M];
			for(int row = 0; row < N; row++) {
				for(int col = 0; col < M; col++) {
					temp2[row][col] = arr[row][col];
				}
			} // 배열 복사
			
			int i = 0; int j = 0;
			arr = new int[M][N];
			for(int col = 0; col < M; col++) {
				for(int row = N - 1; row >= 0; row--) {
					arr[i][j++] = temp2[row][col];
				}
				i++; j = 0;
			}
			
			t = N; N = M; M = t;
		}
		else if(r == 4) { // 왼쪽 90도 회전 -> 문제
			int temp2[][];
			temp2 = new int[N][M];
			for(int row = 0; row < N; row++) {
				for(int col = 0; col < M; col++) {
					temp2[row][col] = arr[row][col];
				}
			} // 배열 복사
			
			int i = 0; int j = 0;
			arr = new int[M][N];
			for(int col = M - 1; col >= 0; col--) {
				for(int row = 0; row < N; row++) {
					arr[i][j++] = temp2[row][col];
				}
				i++; j = 0;
			}
			
			t = N; N = M; M = t;
		}
		else if(r == 5) { // 시계방향 부분 이동
			int subtemp1[][] = new int[N/2][M/2]; int subtemp2[][] = new int[N/2][M/2];
			int subtemp3[][] = new int[N/2][M/2]; int subtemp4[][] = new int[N/2][M/2];
			int i1 = 0; int i2 = 0; int i3 = 0; int i4 = 0;
			int j1 = 0; int j2 = 0; int j3 = 0; int j4 = 0;
			for(int row = 0; row < N; row++) {
				for(int col = 0; col < M; col++) {
					if(row < N/2 && col < M/2) {
						subtemp1[i1][j1++] = arr[row][col];
					}
					else if(row < N/2 && col >= M/2) {
						subtemp2[i2][j2++] = arr[row][col];
					}
					else if(row >= N/2 && col < M/2) {
						subtemp3[i3][j3++] = arr[row][col];
					}
					else if(row >= N/2 && col >= M/2) {
						subtemp4[i4][j4++] = arr[row][col];
					}			
				}
				
				if(row < N/2) {
					i1++; i2++;
				}
				else if(row >= N/2) {
					i3++; i4++;
				}
				j1 = 0; j2 = 0; j3 = 0; j4 = 0; 
			} // 배열 복사
			
			i1 = 0;i2 = 0; i3 = 0; i4 = 0;
			j1 = 0; j2 = 0; j3 = 0; j4 = 0;
			for(int row = 0; row < N; row++) {
				for(int col = 0; col < M; col++) {
					if(row < N/2 && col < M/2) {
						arr[row][col] = subtemp3[i3][j3++];
					}
					else if(row < N/2 && col >= M/2) {
						arr[row][col] = subtemp1[i1][j1++];
					}
					else if(row >= N/2 && col < M/2) {
						arr[row][col] = subtemp4[i4][j4++];
					}
					else if(row >= N/2 && col >= M/2) {
						arr[row][col] = subtemp2[i2][j2++];
					}			
				}
				
				if(row < N/2) {
					i3++; i1++;
				}
				else if(row >= N/2) {
					i4++; i2++;
				}
				j1 = 0; j2 = 0; j3 = 0; j4 = 0; 
			}
		}
		else if(r == 6) { // 반시계 방향 부분 이동
			int subtemp1[][] = new int[N/2][M/2]; int subtemp2[][] = new int[N/2][M/2];
			int subtemp3[][] = new int[N/2][M/2]; int subtemp4[][] = new int[N/2][M/2];
			int i1 = 0; int i2 = 0; int i3 = 0; int i4 = 0;
			int j1 = 0; int j2 = 0; int j3 = 0; int j4 = 0;
			for(int row = 0; row < N; row++) {
				for(int col = 0; col < M; col++) {
					if(row < N/2 && col < M/2) {
						subtemp1[i1][j1++] = arr[row][col];
					}
					else if(row < N/2 && col >= M/2) {
						subtemp2[i2][j2++] = arr[row][col];
					}
					else if(row >= N/2 && col < M/2) {
						subtemp3[i3][j3++] = arr[row][col];
					}
					else if(row >= N/2 && col >= M/2) {
						subtemp4[i4][j4++] = arr[row][col];
					}			
				}
				
				if(row < N/2) {
					i1++; i2++;
				}
				else if(row >= N/2) {
					i3++; i4++;
				}
				j1 = 0; j2 = 0; j3 = 0; j4 = 0; 
			} // 배열 복사
			
			i1 = 0;i2 = 0; i3 = 0; i4 = 0;
			j1 = 0; j2 = 0; j3 = 0; j4 = 0;
			for(int row = 0; row < N; row++) {
				for(int col = 0; col < M; col++) {
					if(row < N/2 && col < M/2) {
						arr[row][col] = subtemp2[i2][j2++];
					}
					else if(row < N/2 && col >= M/2) {
						arr[row][col] = subtemp4[i4][j4++];
					}
					else if(row >= N/2 && col < M/2) {
						arr[row][col] = subtemp1[i1][j1++];
					}
					else if(row >= N/2 && col >= M/2) {
						arr[row][col] = subtemp3[i3][j3++];
					}			
				}
				
				if(row < N/2) {
					i2++; i4++;
				}
				else if(row >= N/2) {
					i1++; i3++;
				}
				j1 = 0; j2 = 0; j3 = 0; j4 = 0; 
			}
		}	
	} // end of function - rotate()
} // end of class

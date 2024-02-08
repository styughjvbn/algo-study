import java.io.*;
import java.util.*;;

public class Main {

	static int[][] map;
	static int[][] newMap;
	static int n, m;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder stb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<r; i++) {
			int cmd = Integer.parseInt(st.nextToken());
			switch(cmd) {
			case 1:
				UpDown();
				break;
			case 2:
				LeftRight();
				break;
			case 3:
				TurnRight();
				break;
			case 4:
				TurnLeft();
				break;
			case 5:
				partialArr1();
				break;
			case 6:
				partialArr2();
				break;
			}
		}
		
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++){
                stb.append(map[i][j]).append(" ");
            }
			stb.append("\n");
		}
        System.out.println(stb);
	} // end of main

	
	public static void UpDown() {
		newMap = new int[n][m];
		for(int r=n-1; r>=0; r--) {
			for(int c=0; c<m; c++) {
				newMap[r][c] = map[n-1-r][c];
			}

		}
		map = newMap;
	}
	
	public static void LeftRight() {
		newMap = new int[n][m];
		for(int r=0; r<n; r++) {
			for(int c=m-1; c>=0; c--) {
				newMap[r][c] = map[r][m-1-c];
			}
		}
		map = newMap;
	}
	
	public static void TurnRight() {
		newMap = new int[m][n];
		int j=0;
		for(int r=0; r<m; r++) {
			int i=n-1;
			for(int c=0; c<n; c++) {
				newMap[r][c] = map[i--][j];
			}
			j++;
		}
		int temp = n;
		n = m;
		m = temp;
		map = newMap;
	}
	
	public static void TurnLeft() {
		newMap = new int[m][n];
		int j=0;
		for(int r=m-1; r>=0; r--) {
			int i=n-1;
			for(int c=n-1; c>=0; c--) {
				newMap[r][c] = map[i--][j];
			}
			j++;
		}
		int temp = n;
		n = m;
		m = temp;
		map = newMap;
	}
	
	public static void partialArr1() {
		newMap = new int[n][m];
		// 1그룹을 2그룹으로
		for(int r=0; r<n/2; r++) {
			for(int c=0; c<m/2; c++) {
				newMap[r][c+(m/2)] = map[r][c];
			}
		}
		// 2그룹을 3그룹으로 
		for(int r=0; r<n/2; r++) {
			for(int c=m/2; c<m; c++) {
				newMap[r+(n/2)][c] = map[r][c];
			}
		}
		// 3그룹을 4그룹으로
		for(int r=n/2; r<n; r++) {
			for(int c=m/2; c<m; c++) {
				newMap[r][c-(m/2)] = map[r][c];
			}
		}
		// 4그룹을 1그룹으로
		for(int r=n/2; r<n; r++) {
			for(int c=0; c<m/2; c++) {
				newMap[r-(n/2)][c] = map[r][c];
			}
		}
		map = newMap;
	}

	public static void partialArr2() {
		newMap = new int[n][m];
		// 1그룹을 4그룹으로
		for(int r=0; r<n/2; r++) {
			for(int c=0; c<m/2; c++) {
				newMap[r+(n/2)][c] = map[r][c];
			}
		}
		// 2그룹을 1그룹으로 
		for(int r=0; r<n/2; r++) {
			for(int c=m/2; c<m; c++) {
				newMap[r][c-(m/2)] = map[r][c];
			}
		}
		// 3그룹을 2그룹으로
		for(int r=n/2; r<n; r++) {
			for(int c=m/2; c<m; c++) {
				newMap[r-(n/2)][c] = map[r][c];
			}
		}
		// 4그룹을 3그룹으로
		for(int r=n/2; r<n; r++) {
			for(int c=0; c<m/2; c++) {
				newMap[r][c+(m/2)] = map[r][c];
			}
		}
		map = newMap;
	}
	
}  // end of class

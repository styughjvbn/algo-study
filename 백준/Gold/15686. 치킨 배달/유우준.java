import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] arr;
	static int home_cnt, chicken_cnt;
	static Pair[] home;
	static Pair[] chicken;
	static int res = Integer.MAX_VALUE;
	
	
	static class Pair {
		int row;
		int col;
		
		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str = br.readLine();
		st = new StringTokenizer(str);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N + 1][N + 1];
		home = new Pair[2*N];
		chicken = new Pair[13];
		for(int row = 1; row <= N; row++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			for(int col = 1; col <= N; col++) {
				arr[row][col] = Integer.parseInt(st.nextToken());
				if(arr[row][col] == 1) {home[home_cnt++] = new Pair(row,col);}
				else if(arr[row][col] == 2) {chicken[chicken_cnt++] = new Pair(row,col);}
			}
		} // 지역 정보 배열 입력 완료 - 0:빈칸, 1:집, 2:치킨집
		
//		for(int i = 0; i < home_cnt; i++) {
//			System.out.print(i + ": (" + home[i].row + ", " + home[i].col + ") ");
//		}
//		System.out.println();
		
		int[] p = new int[chicken_cnt];
		for(int i = M; i < chicken_cnt; i++) {p[i] = 1;}
		do {
//			for(int i = 0; i < p.length; i++) {
//				if(p[i] == 0) {
//					System.out.print(i + ": (" + chicken[i].row + ", " + chicken[i].col + ") ");
//				}// 선택한 치킨집 인덱스 출력, p[i] = 0인 경우가 선택된 치킨집
//			}
//			System.out.println();
			chicken_road(p, home); // 살릴 치킨 집을 선택하고 해당 치킨집을 통해 완탐으로 최소 치킨 거리를 구함
		} while(np(p));
		System.out.println(res);
	}

	private static void chicken_road(int[] p, Pair[] home) {
		int city_chicken_road = 0;
		for(int h = 0; h < home_cnt; h++) {
			int min_d = Integer.MAX_VALUE;
			int home_r = home[h].row; int home_c = home[h].col;
			for(int c = 0; c < p.length; c++) {
				if(p[c] == 0) {
					min_d = Math.min(min_d, Math.abs(home_r - chicken[c].row) + Math.abs(home_c - chicken[c].col)); 
				}
			}
//			System.out.println(min_d);
			city_chicken_road += min_d;
		}
//		System.out.println(city_chicken_road);
		res = Math.min(res, city_chicken_road);
	}

	private static boolean np(int[] p) {
		int i = p.length - 1;		
		while(i > 0 && p[i - 1] >= p[i]) {i--;}
		if(i == 0) {return false;}
		
		int j = p.length - 1;
		while(p[i - 1] >= p[j]) {j--;}
		
		swap(p, i - 1, j);
		int k = p.length - 1;
		while(i < k) {swap(p, i++, k--);}
		return true;
	}

	private static void swap(int[] p, int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}
}

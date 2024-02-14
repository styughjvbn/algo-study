import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
//	static int cnt = -1;
	static int cnt = 0;
//	static int r;
//	static int c;
//	static boolean stop;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		String str = br.readLine();
		st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		recursion(r, c, N);
		System.out.println(cnt);
		
//		N = (int)Math.pow(2, N);
//		recursion(0, 0, N);
	}

	private static void recursion(int row, int col, int size) {
		while(size > 0) {
			int range = (int)Math.pow(2, size - 1);
			
			// 왼쪽 위 
			if(row < range && col < range) {
				cnt += (range * range * 0);
			}
		
			// 오른쪽 위
			else if(row < range && col >= range) {
				cnt += (range * range * 1);
				col -= range;
			}
			
			// 왼쪽 아래
			else if(row >= range && col < range) {
				cnt += (range * range * 2);
				row -= range;
			}
			
			// 오른쪽 아래
			else if(row >= range && col >= range) {
				cnt += (range * range * 3);
				row -= range;
				col -= range;
			}
			
			size--;
		}
	}
//	private static void recursion(int row, int col, int size) {
//		if(stop) {return;}
//		
//		if(size == 1) {
//			cnt++;
//			if(row == r && col == c) {System.out.println(cnt); stop = true;}
//			return;
//		}
//				
//		int half_size = size / 2;
//		recursion(row, col, half_size);
//		recursion(row, col + half_size, half_size);
//		recursion(row + half_size, col, half_size);
//		recursion(row + half_size, col + half_size, half_size);
//	}
}

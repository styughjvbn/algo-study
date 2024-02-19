import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//02/14(수) - <과제> 쿼드트리 
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		String str;
		for(int row = 0; row < N; row++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			String[] temp = st.nextToken().split("");
			for(int col = 0; col < N; col++) {
				arr[row][col] = Integer.parseInt(temp[col]);
			}
		}
				
		recursion(0, 0, N);
		System.out.println(sb);
	}

	private static void recursion(int r, int c, int size) {
		int sum = 0;
		for (int i = r + size - 1; i >= r; i--) {
			for (int j = c + size - 1; j >= c; j--) {
				sum += arr[i][j];
			}
		}
		
		if(sum == size * size) {
			sb.append("1");
		}
		else if(sum == 0) {
			sb.append("0");
		}
		else {
			int half_size = size / 2;
			sb.append("(");
			recursion(r, c, half_size); // 좌상
			recursion(r, c + half_size, half_size); // 우상
			recursion(r + half_size, c, half_size); // 좌하
			recursion(r + half_size, c + half_size, half_size); // 우하
			sb.append(")");
		}
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	private static int map[][];
	private static StringBuilder stb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		stb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		cut(0, 0, n);
		System.out.println(stb);
	}

	private static void cut(int r, int c, int size) {
		int sum = 0;
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				sum += map[i][j];
			}
		}
		if(sum == 0) {
			stb.append("0");
		}
		else if (sum == size*size) {
			stb.append("1");
		}
		else {
			stb.append("(");
			int half = size/2;
			cut(r, c, half);
			cut(r, c+half, half);
			cut(r+half, c, half);
			cut(r+half, c+half, half);
			stb.append(")");
		}
	}
}

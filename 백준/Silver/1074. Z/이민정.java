import java.io.*;
import java.util.*;

public class Main {
	
	static int count = 0;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int length = (int) Math.pow(2, n);
		visited(length, r, c);
		System.out.println(count);
	}
	
	public static void visited(int length, int row, int col) {
		if (length == 1) return;
		
		if (row < (length/2) && col < (length/2)) { // 1사분면
			visited(length/2, row, col);
		} else if (row < (length/2) && col >= (length/2)) { // 2사분면
			
			count += (length * length) / 4;
			visited(length/2, row, col - (length/2));
		} else if (row >= (length/2) && col < (length/2)) {  // 3사분면
			count += (length * length) / 4 * 2;
			visited(length/2, row - (length/2), col);
		} else { // 4사분면
			count += (length * length) / 4 * 3;
			visited(length/2, row - (length/2), col - (length/2));
		}
	}

}

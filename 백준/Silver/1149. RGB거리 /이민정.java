import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int[][] rgb = new int[n][3];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(i==0) {
				rgb[i][0] = r;
				rgb[i][1] = g;
				rgb[i][2] = b;
			}
			else{
				rgb[i][0] = Math.min(rgb[i-1][1], rgb[i-1][2]) + r;
				rgb[i][1] = Math.min(rgb[i-1][0], rgb[i-1][2]) + g;
				rgb[i][2] = Math.min(rgb[i-1][0], rgb[i-1][1]) + b;
			}
		}
		int min = Integer.MAX_VALUE;
		min = Math.min(rgb[n-1][0], rgb[n-1][1]);
		min = Math.min(min, rgb[n-1][2]);

		System.out.println(min);
	} // end of main
} // end of class

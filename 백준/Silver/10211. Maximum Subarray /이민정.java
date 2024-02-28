import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] sum = new int[n];
			int max = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(j==0) {
					sum[j] = num;
					max = num;
				}
				else sum[j] = Math.max(sum[j-1]+num, num);
				max = Math.max(max, sum[j]);
			}
			stb.append(max).append("\n");
		}
		System.out.println(stb);
	}
}

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		long N = Long.parseLong(s.nextToken());
		long L = Long.parseLong(s.nextToken());
		long W = Long.parseLong(s.nextToken());
		long H = Long.parseLong(s.nextToken());
		double l = 0;
		double r = 1000000001;
		double ans = 0;
		long A = 0;
		long B = 0;
		long C = 0;
		while (l<=r) {
			double m = (l+r)/2;
			A = (long)(L/m);
			B = (long)(W/m);
			C = (long)(H/m);
			if ((A*B*C)<N) {
				if (r==m) {
					break;
				}
				r = m;
			} else {
				if (l==m) {
					break;
				}
				l = m;
				ans = m;
			}
		}
		System.out.println(ans);
	}
}

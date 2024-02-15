import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long L = Long.parseLong(st.nextToken());
		long W = Long.parseLong(st.nextToken());
		long H = Long.parseLong(st.nextToken());

		double start = 0;
		double end = Math.min(Math.min(L, W), H);
		double mid = -1;

		for (int i = 0; i < 1000; ++i) { // 최대 한변의 길이 1,000 // 1,000^3 = 1,000,000,000
			mid = (start + end) / 2;

			if ((long)(L / mid) * (long)(W / mid) * (long)(H / mid) < N) {
				end = mid; // mid가 분모이기 때문에 start = mid (X)
			} // 1번 case
			else {
				start = mid;
			} // 2번 case
		}

		System.out.print(start);
		// 1번 case에서 끝난 경우 가장 근사치
		// 2번 case에서 끝난 경우 mid는 N보다 클 경우도 존재
		// 따라서 start 출력	
	}
}

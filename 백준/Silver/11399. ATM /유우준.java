import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		st = new StringTokenizer(str);
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr); // 우선순위 큐를 사용하면 N^2을 logN으로 줄일 수 있을 것 같음
		
		// 1 2 3 3 4 -> 1(0+1), 3(1+2), 6(3+3), 9(6+3), 13(9+4)
		int cnt = 0; int prev_cnt = 0; int res = 0;
		for(int i = 0; i < N; i++) {
			cnt = prev_cnt + arr[i];
			prev_cnt = cnt; // cnt = 한 사람이 걸리는 시간 (이전 사람들 시간 총 합 + 자기 시간)
			
			res += cnt; // res = 모든 사람이 걸리는 시간
		} // O(N)
		
		System.out.println(res);
	}
}

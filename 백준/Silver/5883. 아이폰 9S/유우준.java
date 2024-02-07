import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//02/06(화) - <스터디> 아이폰 9S
public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Set<Integer> s = new HashSet<>();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			int B = Integer.parseInt(br.readLine());
			arr[i] = B;
			s.add(B);
		}
		
		int max_cnt = 1;
		Iterator<Integer> iter = s.iterator();
		while (iter.hasNext()) {
			int val = iter.next();
			int cnt = 1; int prev = arr[0];
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] == val) {continue;} // 제거했다고 가정

				if (arr[i] != prev) {
					cnt = 1;
					prev = arr[i];
				} // 길이 갱신 초기화
				else {
					cnt++;
					max_cnt = Math.max(cnt, max_cnt);
				} // 이전 용량과 같을 경우 길이를 업데이트하고 최댓값 비교
			}
		}
		System.out.println(max_cnt);
	}
}

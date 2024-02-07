
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

//02/07(수) - <스터디> 스위치와 램프
public class S08_BJ_16960 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str = br.readLine();
		st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken()); // 스위치 개수 -> N 4
		int M = Integer.parseInt(st.nextToken()); // 램프 개수 -> M 5
		Set<Integer> lamp = new HashSet<>();
		for(int i = 1; i <= M; i++) {
			lamp.add(i);
		} // 램프 개수만큼 번호 할당
		
		List<List<Integer>> switches = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			int size = Integer.parseInt(st.nextToken());
			List<Integer> s = new ArrayList<>();
			for(int j = 1; j <= size; j++) {
				s.add(Integer.parseInt(st.nextToken()));
			}
			switches.add(s);
		} // 각 스위치의 켤 수 있는 램프 정보 저장
		
		int res = 0; int skip = 0;
		Set<Integer> temp = new HashSet<>();
		for (int i = 0; i < N; i++) { // 스위치 N개 (0번만 제외, 1번만 제외, ...)
			
			for (int row = 0; row < switches.size(); row++) {
				if (skip == row) {continue;} // 스위치 n번만 제외하기 위함
				for (int col = 0; col < switches.get(row).size(); col++) {
					temp.add(switches.get(row).get(col));
				}
			}
			if (temp.size() == lamp.size()) {res = 1; break;} // N-1개 스위치로 전부 킨 경우
			skip++; temp.clear();
		}
		
		System.out.println(res);
	}
}

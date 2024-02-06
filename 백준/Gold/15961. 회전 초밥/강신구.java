import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(s.nextToken());
		int D = Integer.parseInt(s.nextToken());
		int K = Integer.parseInt(s.nextToken());
		int C = Integer.parseInt(s.nextToken());
		ArrayList<Integer> q = new ArrayList<>();
		HashMap<Integer, Integer> dict = new HashMap<>();
		int Max = 0;
		for (int a=0; a<N; a++) {
			int num = Integer.parseInt(br.readLine());
			q.add(num);
			if (a<K) {
				// 추가
				if (dict.containsKey(num)) {
					dict.put(num, dict.get(num)+1);
				} else {
					dict.put(num, 1);
				}	
			} else {
				// 검사
				if (dict.containsKey(C)) {
					Max = Math.max(Max, dict.size());
				} else {
					Max = Math.max(Max, dict.size()+1);
				}
				// 추가
				if (dict.containsKey(num)) {
					dict.put(num,  dict.get(num)+1);
				} else {
					dict.put(num, 1);
				}
				// 삭제
				int Remove = q.get(a-K);
				if (dict.get(Remove)==1) {
					dict.remove(Remove);
				} else {
					dict.put(Remove, dict.get(Remove)-1);
				}
			}
		}
		if (N>K) {
			// 마지막 배열까지 추가 후 검사
			if (dict.containsKey(C)) {
				Max = Math.max(Max, dict.size());
			} else {
				Max = Math.max(Max, dict.size()+1);
			}
			// 앞에서 부터 다시 채우기
			for (int a=0; a<K-1; a++) {
				int New = q.get(a);
				// 추가
				if (dict.containsKey(New)) {
					dict.put(New, dict.get(New)+1);
				} else {
					dict.put(New, 1);
				}
				// 삭제
				int Remove = q.get(N-K+a);
				if (dict.get(Remove)==1) {
					dict.remove(Remove);
				} else {
					dict.put(Remove, dict.get(Remove)-1);
				}
				// 검사
				if (dict.containsKey(C)) {
					Max = Math.max(Max, dict.size());
				} else {
					Max = Math.max(Max, dict.size()+1);
				}
			}
		} else {
			// 검사
			if (dict.containsKey(C)) {
				Max = Math.max(Max, dict.size());
			} else {
				Max = Math.max(Max, dict.size()+1);
			}
		}
		System.out.println(Max);
	}
}

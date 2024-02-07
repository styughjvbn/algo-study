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
		int N = Integer.parseInt(s.nextToken());	// 스위치 수
		int M = Integer.parseInt(s.nextToken());	// 램프 수
		HashMap<Integer, Integer> dict = new HashMap<>();
		HashMap<Integer, ArrayList<Integer>> q = new HashMap<>();
		for (int a=1; a<=N; a++) {
			s = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(s.nextToken());
			q.put(a, new ArrayList<>());
			for (int b=0; b<K; b++) {
				int num = Integer.parseInt(s.nextToken());
				q.get(a).add(num);
				if (dict.containsKey(num)) {
					dict.put(num, dict.get(num)+1);
				} else {
					dict.put(num, 1);
				}
			}
		}
		boolean flag = false;
		for (int a=1; a<=N; a++) {
			boolean flag2 = true;
			for (int b : q.get(a)) {
				if (dict.get(b)==1) {
					flag2 = false;
					break;
				}
			}
			if (flag2) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}

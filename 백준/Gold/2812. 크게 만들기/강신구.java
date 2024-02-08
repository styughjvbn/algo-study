import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(s.nextToken());
		int K = Integer.parseInt(s.nextToken());
		String sen = br.readLine();
		int cnt = 0;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int a=0; a<N; a++) {
			int num = sen.charAt(a)-'0';
			if (q.size()==0) {
				q.add(num);
			} else {
				if (q.peekLast()>=num) {
					q.add(num);
				} else {
					while (cnt<K && q.size()>0 && q.peekLast()<num) {
						q.pollLast();
						cnt+=1;
					}
					q.add(num);
				}
			}
		}
		while (cnt<K) {
			cnt+=1;
			q.pollLast();
		}
		StringBuilder ans = new StringBuilder();
		while (!q.isEmpty()) {
			ans.append(q.pollFirst());
		}
		System.out.println(ans);
    }
}

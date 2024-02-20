import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {
	static StringTokenizer s;
	static String com;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
    // ArrayDeque보다 LinkedList가 더 빠르다.
		ArrayDeque<Integer> q = new ArrayDeque<>();
		StringBuilder ans = new StringBuilder();
		for (int a=0; a<N; a++) {
			s = new StringTokenizer(br.readLine());
			com = s.nextToken();
			if (com.equals("push")) {
				q.add(Integer.parseInt(s.nextToken()));
			} else if (com.equals("pop")) {
				if (!q.isEmpty()) {
					ans.append(q.pollFirst()+"\n");
				} else {
					ans.append(-1+"\n");
				}
			} else if (com.equals("size")) {
				ans.append(q.size()+"\n");
			} else if (com.equals("empty")) {
				if (q.isEmpty()) {
					ans.append(1+"\n");
				} else {
					ans.append(0+"\n");
				}
			} else if (com.equals("front")) {
				if (!q.isEmpty()) {
					ans.append(q.peekFirst()+"\n");
				} else {
					ans.append(-1+"\n");
				}
			} else if (com.equals("back")) {
				if (!q.isEmpty()) {
					ans.append(q.peekLast()+"\n");
				} else {
					ans.append(-1+"\n");
				}
			}
		}
		System.out.println(ans);
	}
}

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sen = br.readLine();
		PriorityQueue<String> q = new PriorityQueue<>();
		String tmp = "";
		for (int a=sen.length()-1; a>=0; a--) {
			tmp = sen.charAt(a) + tmp;
			q.add(tmp);
		}
		StringBuilder ans = new StringBuilder();
		while (!q.isEmpty()) {
			ans.append(q.poll()+"\n");
		}
		System.out.println(ans);
    }
}

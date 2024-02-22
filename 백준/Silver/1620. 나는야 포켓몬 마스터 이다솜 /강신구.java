import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(s.nextToken());
		int M = Integer.parseInt(s.nextToken());
		HashMap<String, String> dict = new HashMap<>();
		String name;
		for (int a=1; a<=N; a++) {
			name = br.readLine();
			dict.put(name, String.valueOf(a));
			dict.put(String.valueOf(a), name);
		}
		StringBuilder ans = new StringBuilder();
		for (int a=0; a<M; a++) {
			ans.append(dict.get(br.readLine())+"\n");
		}
		System.out.println(ans);
	}
}

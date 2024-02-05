import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(s.nextToken());
		int M = Integer.parseInt(s.nextToken());
		HashSet<String> dict = new HashSet<>();
		for (int a=0; a<N; a++) {
			dict.add(br.readLine());
		}
		int ans = 0;
		for (int a=0; a<M; a++) {
			if (dict.contains(br.readLine())) {
				ans+=1;
			}
		}
		System.out.println(ans);
	}
}

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
	static int N;
	static int M;
	static String[] arr;
	static int ans = 0;
	
	public static void check() {
		HashMap<Integer, StringBuilder> dict = new HashMap<>();
		for (int b=0; b<M; b++) {
			StringBuilder tmp = new StringBuilder();
			for (int a=0; a<N; a++) {
				tmp.append(arr[a].charAt(b));
			}
			dict.put(b, tmp);
		}
		for (int a=1; a<N; a++) {
			HashSet<String> set = new HashSet<>();
			for (int b=0; b<M; b++) {
				String tmp = dict.get(b).substring(a,N);
				if (set.contains(tmp)) {
					return;
				}
				set.add(tmp);
			}
			ans+=1;
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		N = Integer.parseInt(s.nextToken());
		M = Integer.parseInt(s.nextToken());
		arr = new String[N];
		for (int a=0; a<N; a++) {
			arr[a] = br.readLine();
		}
		check();
		System.out.println(ans);
    }
}

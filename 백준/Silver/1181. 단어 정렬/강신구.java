import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<String> arr = new ArrayList<>();
		HashSet<String> Set = new HashSet<>();
		for (int a=0; a<N; a++) {
			String s = br.readLine();
			if (!Set.contains(s)) {
				arr.add(s);
				Set.add(s);
			}
		}
		Collections.sort(arr, (o1, o2) -> {
			if (o1.length() == o2.length()) {
				return o1.compareTo(o2);
			}
			return o1.length() - o2.length();
		});
		StringBuilder ans = new StringBuilder();
		for (int a=0; a<arr.size(); a++) {
			ans.append(arr.get(a)+"\n");
		}
		System.out.println(ans);
	}
}

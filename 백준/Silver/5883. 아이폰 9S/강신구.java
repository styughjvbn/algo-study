import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		HashSet<Integer> Set = new HashSet<>();
		for (int a=0; a<N; a++) {
			int num = Integer.parseInt(br.readLine());
			arr[a] = num;
			Set.add(num);
		}
		int Max = 0;
		for (int num : Set) {
			int pre = -1;
			int cnt = 0;
			for (int a=0; a<N; a++) {
				if (num==arr[a]) {
					continue;
				}
				if (pre!=arr[a]) {
					Max = Math.max(Max, cnt);
					pre = arr[a];
					cnt = 1;
				} else {
					cnt += 1;
				}
			}
			Max = Math.max(Max, cnt);
		}
		System.out.println(Max);
	}
}

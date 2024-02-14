import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer s = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int a=0; a<N; a++) {
			arr[a] = Integer.parseInt(s.nextToken());
		};
		Arrays.sort(arr);
		long ans = 0;
		for (int a=0; a<N-2; a++) {
			for (int b=a+1; b<N-1; b++) {
				int l = b+1;
				int r = N-1;
				int loc1 = l;
				while (l<=r) {
					int m = (l+r)/2;
					if (arr[a]+arr[b]+arr[m]>0) {
						r = m-1;
					} else {
						l = m+1;
						loc1 = m;
					}
				}
				l = b+1;
				r = N-1;
				int loc2 = l;
				while (l<=r) {
					int m = (l+r)/2;
					if (arr[a]+arr[b]+arr[m]>=0) {
						r = m-1;
						loc2 = m-1;
					} else {
						l = m+1;
						loc2 = m;
					}
				}
				if (arr[a]+arr[b]+arr[loc1]==0) {
					ans += loc1-loc2;
				}
			}
		}
		System.out.println(ans);
	}
}

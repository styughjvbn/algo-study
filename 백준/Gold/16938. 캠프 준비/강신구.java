import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int L;
	static int R;
	static int X;
	static int[] arr;
	static int ans = 0;
	
	public static void check(int Max, int Min, int hap, int cnt, int loc) {
		if (cnt>1 && L<=hap && hap<=R && (Max-Min>=X)) {
			ans += 1;
		}
		for (int a=loc; a<N; a++) {
			check(Math.max(Max, arr[a]), Math.min(Min, arr[a]), hap+arr[a], cnt+1, a+1);
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		N = Integer.parseInt(s.nextToken());
		L = Integer.parseInt(s.nextToken());
		R = Integer.parseInt(s.nextToken());
		X = Integer.parseInt(s.nextToken());
		s = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int a=0; a<N; a++) {
			arr[a] = Integer.parseInt(s.nextToken());
		}
		for (int a=0; a<N; a++) {
			check(arr[a], arr[a], arr[a], 1,a+1);
		}
		System.out.println(ans);
    }
}

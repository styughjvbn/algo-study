import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	static int Max = 0;
	static boolean[] visited;
	static int[] select;
	
	public static void check() {
		int hap = 0;
		for (int a=0; a<N-1; a++) {
			hap += Math.abs(arr[select[a]] - arr[select[a+1]]);
		}
		Max = Math.max(Max, hap);
	}
	
	public static void perm(int loc) {
		if (loc==N) {
			check();
			return;
		}
		for (int a=0; a<N; a++) {
			if (visited[a]) {
				continue;
			}
			visited[a] = true;
			select[loc] = a;
			perm(loc+1);
			visited[a] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer s = new StringTokenizer(br.readLine());
		arr = new int[N];
		visited = new boolean[N];
		select = new int[N];
		for (int a=0; a<N; a++) {
			arr[a] = Integer.parseInt(s.nextToken());
		}
		for (int a=0; a<N; a++) {
			visited[a] = true;
			select[0] = a;
			perm(1);
			visited[a] = false;
		}
		System.out.println(Max);
	}
}

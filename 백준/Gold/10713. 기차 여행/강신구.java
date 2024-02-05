import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(s.nextToken());
		int M = Integer.parseInt(s.nextToken());
		int[] seq = new int[M];
		s = new StringTokenizer(br.readLine());
		for (int a=0; a<M; a++) {
			seq[a] = Integer.parseInt(s.nextToken());
		}
		long[] tickets = new long[N];
		long[] ICU = new long[N];
		long[] IC = new long[N];
		for (int a=1; a<N; a++) {
			s = new StringTokenizer(br.readLine());
			tickets[a] = Long.parseLong(s.nextToken());
			ICU[a] = Long.parseLong(s.nextToken());
			IC[a] = Long.parseLong(s.nextToken());
		}
		int[] hap = new int[N];
		for (int a=0; a<M-1; a++) {
			int st = Math.min(seq[a], seq[a+1]);
			int nd = Math.max(seq[a], seq[a+1]);
			hap[st] += 1;
			if (nd<N) {
				hap[nd] -= 1;
			}
		}
		for (int a=1; a<N; a++) {
			hap[a] += hap[a-1];
		}
		long ans = 0;
		for (int a=1; a<N; a++) {
			long ic = IC[a]+ICU[a]*hap[a];
			long ti = tickets[a]*hap[a];
			ans += Math.min(ic, ti);
		}
		System.out.println(ans);
    }
}

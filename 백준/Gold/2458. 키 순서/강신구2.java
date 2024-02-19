import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer s;
	static int N;
	static int M;
	static int[][] Map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = new StringTokenizer(br.readLine());
		N = Integer.parseInt(s.nextToken());
		M = Integer.parseInt(s.nextToken());
		Map = new int[N+1][N+1];
		for (int a=0; a<M; a++) {
			s = new StringTokenizer(br.readLine());
			int st = Integer.parseInt(s.nextToken());
			int nd = Integer.parseInt(s.nextToken());
			Map[st][nd] = 1;
			Map[st][st] += 1;
			Map[nd][nd] += 1;
		}
		for (int a=1; a<=N; a++) {
			for (int b=1; b<=N; b++) {
				for (int c=1; c<=N; c++) {
					if (Map[b][a]==1 && Map[a][c]==1 && Map[b][c]!=1) {
						Map[b][c] = 1;
						Map[b][b] += 1;
						Map[c][c] += 1;
					}
				}
			}
		}
		int ans = 0;
		for (int a=1; a<=N; a++) {
			if (Map[a][a] == N-1)  {
				ans += 1;
			}
		}
		System.out.println(ans);
	}
}

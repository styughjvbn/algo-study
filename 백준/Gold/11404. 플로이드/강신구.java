import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] Map = new int[N][N];
		for (int a=0; a<N; a++) {
			for (int b=0; b<N; b++) {
				if (a==b) {
					Map[a][b] = 0;
				} else {
					Map[a][b] = 1000000000;
				}
			}
		}
		for (int a=0; a<M; a++) {
			StringTokenizer s = new StringTokenizer(br.readLine());
			int st = Integer.parseInt(s.nextToken()) -1;
			int nd = Integer.parseInt(s.nextToken()) -1;
			Map[st][nd] = Math.min(Map[st][nd], Integer.parseInt(s.nextToken()));
		}
		for (int a=0; a<N; a++) {
			for (int b=0; b<N; b++) {
				for (int c=0; c<N; c++) {
					Map[b][c] = Math.min(Map[b][c], Map[b][a] + Map[a][c]);
				}
			}
		}
		StringBuilder ans = new StringBuilder();
		for (int a=0; a<N; a++) {
			for (int b=0; b<N; b++) {
				if (Map[a][b]==1000000000) {
					ans.append(0+" ");
				} else {
					ans.append(Map[a][b]+" ");
				}
			}
			ans.append("\n");
		}
		System.out.println(ans);
    }
}

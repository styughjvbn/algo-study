import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer s;
	static int N;
	static int[][] Map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Map = new int[N+1][N+1];
		for (int a=1; a<=N; a++) {
			s = new StringTokenizer(br.readLine());
			for (int b=1; b<=N; b++) {
				Map[a][b] = Map[a][b-1] + Integer.parseInt(s.nextToken());
			}
			for (int b=1; b<=N; b++) {
				Map[a][b] += Map[a-1][b];
			}
		}
		int Max = -1000000000;
		for (int a=1; a<=N; a++) {
			for (int b=a; b<=N; b++) {
				for (int c=a; c<=N; c++) {
					Max = Math.max(Max, Map[b][c] + Map[b-a][c-a] - Map[b][c-a] - Map[b-a][c]);
				}
			}
		}
		System.out.println(Max);
	}
}

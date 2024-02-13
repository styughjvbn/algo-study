import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static int N;
	static int M;
	static int r;
	static int c;
	static int[][] Map;
	static int[] dr = {0, 0, 0, -1, 1};
	static int[] dc = {0, 1, -1, 0, 0};
	static ArrayList<Integer> up = new ArrayList<>(Arrays.asList(0, 0, 0, 0));
	static ArrayList<Integer> down = new ArrayList<>(Arrays.asList(0, 0, 0, 0));
	static StringBuilder ans = new StringBuilder();
	
	public static void move(int way) {
		int nr = r + dr[way];
		int nc = c + dc[way];
		if (nr<0 || nr>N-1 || nc<0 || nc>M-1) {
			return;
		}
		if (way==1) {			// 동
			down.add(0, down.get(3));
			down.remove(4);
			up.set(0, down.get(0));
			up.set(2, down.get(2));
			if (Map[nr][nc]==0) {
				Map[nr][nc] = up.get(2);
			} else {
				up.set(2, Map[nr][nc]);
				down.set(2, up.get(2));
				Map[nr][nc] = 0;
			}
		} else if (way==2) {	// 서
			down.add(down.get(0));
			down.remove(0);
			up.set(0, down.get(0));
			up.set(2, down.get(2));
			if (Map[nr][nc]==0) {
				Map[nr][nc] = up.get(2);
			} else {
				up.set(2, Map[nr][nc]);
				down.set(2, up.get(2));
				Map[nr][nc] = 0;
			}
		} else if (way==3) {	// 북
			up.add(up.get(0));
			up.remove(0);
			down.set(0, up.get(0));
			down.set(2, up.get(2));
			if (Map[nr][nc]==0) {
				Map[nr][nc] = up.get(2);
			} else {
				up.set(2, Map[nr][nc]);
				down.set(2, up.get(2));
				Map[nr][nc] = 0;
			}
		} else {				// 남
			up.add(0, up.get(3));
			up.remove(4);
			down.set(0, up.get(0));
			down.set(2, up.get(2));
			if (Map[nr][nc]==0) {
				Map[nr][nc] = up.get(2);
			} else {
				up.set(2, Map[nr][nc]);
				down.set(2, up.get(2));
				Map[nr][nc] = 0;
			}
		}
		r = nr;
		c = nc;
		ans.append(up.get(0)+"\n");
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		N = Integer.parseInt(s.nextToken());
		M = Integer.parseInt(s.nextToken());
		r = Integer.parseInt(s.nextToken());
		c = Integer.parseInt(s.nextToken());
		int K = Integer.parseInt(s.nextToken());
		Map = new int[N][M];
		for (int a=0; a<N; a++) {
			s = new StringTokenizer(br.readLine());
			for (int b=0; b<M; b++) {
				Map[a][b] = Integer.parseInt(s.nextToken());
			}
		}
		s = new StringTokenizer(br.readLine());
		for (int a=0; a<K; a++) {
			int way = Integer.parseInt(s.nextToken());
			move(way);
		}
		System.out.println(ans);
	}
}

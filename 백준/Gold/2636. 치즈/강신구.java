import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

class Node {
	int y;
	int x;
	
	Node(int y, int x) {
		this.y = y;
		this.x = x;
	}
	
	int gety() {
		return y;
	}
	
	int getx() {
		return x;
	}
}

public class Main {
	static int N;
	static int M;
	static int[][] Map;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	public static int check() {
		ArrayDeque<Node> q = new ArrayDeque<>();
		ArrayDeque<Node> Remove = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;
		q.add(new Node(0,0));
		while (!q.isEmpty()) {
			Node tmp = q.poll();
			for (int a=0; a<4; a++) {
				int ny = tmp.gety() + dy[a];
				int nx = tmp.getx() + dx[a];
				if (ny<0 || ny>N-1 || nx<0 || nx>M-1) {
					continue;
				}
				if (visited[ny][nx]) {
					continue;
				}
				if (Map[ny][nx]==1 && !visited[ny][nx]) {
					Remove.add(new Node(ny,nx));
					visited[ny][nx] = true;
				} else {
					q.add(new Node(ny,nx));
					visited[ny][nx] = true;
				}
			}
		}
		int cnt = 0;
		while (!Remove.isEmpty()) {
			Node tmp = Remove.poll();
			Map[tmp.gety()][tmp.getx()]-=1;
			cnt += 1;
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		N = Integer.parseInt(s.nextToken());
		M = Integer.parseInt(s.nextToken());
		Map = new int[N][M];
		int now = 0;
		for (int a=0; a<N; a++) {
			s = new StringTokenizer(br.readLine());
			for (int b=0; b<M; b++) {
				Map[a][b] = Integer.parseInt(s.nextToken());
				if (Map[a][b]==1) {
					now += 1;
				}
			}
		}
		int rest = now;
		int Time = 0;
		while (now>0) {
			Time += 1;
			rest = now;
			int minus = check();
			now -= minus;
		}
		System.out.println(Time);
		System.out.println(rest);
	}
}

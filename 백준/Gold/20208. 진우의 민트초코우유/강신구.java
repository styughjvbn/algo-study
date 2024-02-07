import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

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
	static int H;
	static ArrayList<Node> milks;
	static boolean[] visited;
	static int Max = 0;
	static int s_y;
	static int s_x;
	
	public static void moving(int y, int x, int m, int cnt) {
		if (y==s_y & x==s_x) {
			Max = Math.max(Max, cnt-1);
			return;
		}
		for (int a=0; a<milks.size(); a++) {
			if (visited[a]) {
				continue;
			}
			Node tmp = milks.get(a);
			int Next_y = tmp.gety();
			int Next_x = tmp.getx();
			int L = Math.abs(y-Next_y)+Math.abs(x-Next_x);
			if (L<=m) {
				visited[a] = true;
				moving(Next_y, Next_x, m-L+H, cnt+1);
				visited[a] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		N = Integer.parseInt(s.nextToken());
		M = Integer.parseInt(s.nextToken());
		H = Integer.parseInt(s.nextToken());
		milks = new ArrayList<>();
		s_y = -1;
		s_x = -1;
		int mh = 0;
		for (int a=0; a<N; a++) {
			s = new StringTokenizer(br.readLine());
			for (int b=0; b<N; b++) {
				int num = Integer.parseInt(s.nextToken());
				if (num==1) {
					s_y = a;
					s_x = b;
					milks.add(new Node(a,b));
					mh += 1;
				} else if (num==2) {
					milks.add(new Node(a,b));
					mh += 1;
				}
			}
		}
		visited = new boolean[mh];
		for (int a=0; a<milks.size(); a++) {
			Node tmp = milks.get(a);
			int y = tmp.gety();
			int x = tmp.getx();
			if (y==s_y && x==s_x) {
				continue;
			}
			int L = Math.abs(y-s_y)+Math.abs(x-s_x);
			if (L<=M) {
				visited[a] = true;
				moving(y, x, M-L+H, 1);
				visited[a] = false;
			}
		}
		System.out.println(Max);
	}
}

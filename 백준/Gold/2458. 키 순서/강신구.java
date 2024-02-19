import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
	static StringTokenizer s;
	static int N;
	static int M;
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> re_tree = new ArrayList<>();
	
	public static int tree_bfs(int num) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		q.add(num);
		visited[num] = true;
		int cnt = 0;
		while (!q.isEmpty()) {
			int tmp = q.poll();
			cnt += 1;
			for (int Next : tree.get(tmp)) {
				if (visited[Next]) {
					continue;
				}
				q.add(Next);
				visited[Next] = true;
			}
		}
		return cnt;
	}
	
	public static int retree_bfs(int num) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		q.add(num);
		visited[num] = true;
		int cnt = 0;
		while (!q.isEmpty()) {
			int tmp = q.poll();
			cnt += 1;
			for (int Next : re_tree.get(tmp)) {
				if (visited[Next]) {
					continue;
				}
				q.add(Next);
				visited[Next] = true;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = new StringTokenizer(br.readLine());
		N = Integer.parseInt(s.nextToken());
		M = Integer.parseInt(s.nextToken());
		for (int a=0; a<=N; a++) {
			tree.add(new ArrayList<>());
			re_tree.add(new ArrayList<>());
		}
		for (int a=0; a<M; a++) {
			s = new StringTokenizer(br.readLine());
			int st = Integer.parseInt(s.nextToken());
			int nd = Integer.parseInt(s.nextToken());
			tree.get(st).add(nd);
			re_tree.get(nd).add(st);
		}
		int ans = 0;
		for (int a=1; a<=N; a++) {
			int st = tree_bfs(a);
			int nd = retree_bfs(a);
			if (st+nd-1==N) {
				ans += 1;
			}
		}
		System.out.println(ans);
	}
}

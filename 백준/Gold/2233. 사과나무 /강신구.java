import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {
	static int N;
	static int[] seq;
	static int[] indegree;
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	static int st;
	static int nd;
	static int row;
	static ArrayList<Integer> q;
	
	public static void dfs(int num) {
		q.add(num);
		if (num==1) {
			return;
		}
		dfs(tree.get(num).get(0));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		seq = new int[s.length()+1];
		indegree = new int[N+1];
		for (int a=0; a<=N; a++) {
			tree.add(new ArrayList<>());
		}
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		int cnt = 1;
		for (int a=1; a<=s.length(); a++) {
			if (s.charAt(a-1)=='0') {
				seq[a] = cnt;
				stack.add(cnt++);
			} else {
				seq[a] = stack.pollLast();
				indegree[seq[a]] = stack.size();
				if (!stack.isEmpty()) {
					tree.get(seq[a]).add(stack.peekLast());
				}
			}
		}
		StringTokenizer sto = new StringTokenizer(br.readLine());
		st = seq[Integer.parseInt(sto.nextToken())];
		nd = seq[Integer.parseInt(sto.nextToken())];
		q = new ArrayList<>();
		dfs(st);
		while (!q.contains(nd)) {
			nd = tree.get(nd).get(0);
		}
		for (int a=1; a<=2*N; a++) {
			if (seq[a]==nd) {
				System.out.print(a+" ");
			}
		}
	}
}

package baekjoon;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
	int n;
	int cost;
	
	Node(int n, int cost) {
		this.n = n;
		this.cost = cost;
	}
	
	int getn() {
		return n;
	}
	
	int getc() {
		return cost;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}	
}

public class Main {
	static int N;
	static int M;
	static int K;
	static ArrayList<ArrayList<Node>> tree = new ArrayList<>();
	static boolean[] connected;
	static int cnt = 0;
	static int total = 0;
	
	public static void bfs(ArrayList<Integer> installed) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		for (int a : installed) {
			for (Node n : tree.get(a)) {
				if (connected[n.getn()]) {
					continue;
				}
				q.add(n);
			}
		}
		while (!q.isEmpty()) {
			Node tmp = q.poll();
			int Next = tmp.getn();
			int cost = tmp.getc();
			if (connected[Next]) {
				continue;
			}
			cnt += 1;
			total += cost;
			if (cnt==N) {
				return;
			}
			connected[Next] = true;
			for (Node n : tree.get(Next)) {
				if (connected[n.getn()]) {
					continue;
				}
				q.add(n);
			}
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		N = Integer.parseInt(s.nextToken());
		M = Integer.parseInt(s.nextToken());
		K = Integer.parseInt(s.nextToken());
		for (int a=0; a<=N; a++) {
			tree.add(new ArrayList<>());
		}
		connected = new boolean[N+1];
		s = new StringTokenizer(br.readLine());
		ArrayList<Integer> installed = new ArrayList<>();
		for (int a=0; a<K; a++) {
			int num = Integer.parseInt(s.nextToken());
			connected[num] = true;
			installed.add(num);
		}
		cnt = K;
		for (int a=0; a<M; a++) {
			s = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(s.nextToken());
			int y = Integer.parseInt(s.nextToken());
			int z = Integer.parseInt(s.nextToken());
			tree.get(x).add(new Node(y,z));
			tree.get(y).add(new Node(x,z));
		}
		bfs(installed);
		System.out.println(total);
    }
}

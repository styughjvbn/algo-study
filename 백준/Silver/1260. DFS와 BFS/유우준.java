import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static List<List<Integer>> li = new ArrayList<>();
	static boolean[] visited; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str = br.readLine();
		st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <= N; i++) {List<Integer> temp = new ArrayList<>(); li.add(temp);}
		for(int i = 0; i < M; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			int idx = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			li.get(idx).add(val);
			li.get(val).add(idx);
		}
			
		for(int i = 1; i < li.size(); i++) {
			Collections.sort(li.get(i));
		} // 간선 정보 입력 완료
		
		visited = new boolean[N + 1];
		DFS(V);
		
		sb.append("\n");
		
		visited = new boolean[N + 1];
		BFS(V);
		
		System.out.println(sb);
	}

	private static void DFS(int v) {
		visited[v] = true;
		sb.append(v+" ");
		for(int i = 0; i < li.get(v).size(); i++) {
			if(!visited[li.get(v).get(i)]) {
				DFS(li.get(v).get(i));
			}
		}
	}

	private static void BFS(int v) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			int front = q.poll();
			sb.append(front+" ");
			for(int i = 0; i < li.get(front).size(); i++) {
				if(!visited[li.get(front).get(i)]) {
					q.add(li.get(front).get(i));
					visited[li.get(front).get(i)] = true;
				}
			}
		}	
	}
}

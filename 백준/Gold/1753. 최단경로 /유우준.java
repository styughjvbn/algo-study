import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static class Node implements Comparable<Node>{
		int to, weight;
		
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		st = new StringTokenizer(str);
		int V = Integer.parseInt(st.nextToken()); // 정점 개수
		int E = Integer.parseInt(st.nextToken()); // 간선 개수
		int start = Integer.parseInt(br.readLine()); // 시작 정점
		
		List<Node>[] adjList = new ArrayList[V + 1];
		for(int i = 0; i <= V; i++) {adjList[i] = new ArrayList<>();}
		for(int i = 0; i < E; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			int u = Integer.parseInt(st.nextToken()); // 출발 정점 u
			int v = Integer.parseInt(st.nextToken()); // 도착 정점 v
			int w = Integer.parseInt(st.nextToken()); // 가중치 w
			
			adjList[u].add(new Node(v,w)); // v : 도착정점, w : u->v 가중치
		} // 인접리스트 채우기
		
		int INF = Integer.MAX_VALUE;
		int[] minDistance = new int[V + 1];
		Arrays.fill(minDistance, INF);
		boolean[] visited = new boolean[V + 1];
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		minDistance[start] = 0;
		pq.offer(new Node(start, 0)); // 자신이 자신을 방문하는 가중치 0으로 시작
		
		while(!pq.isEmpty()) {
			Node pick = pq.poll();
			
			if(visited[pick.to]) continue;
			visited[pick.to] = true;
			
			for(Node temp : adjList[pick.to]) {
				if(minDistance[temp.to] > minDistance[pick.to] + temp.weight) {
					minDistance[temp.to] = minDistance[pick.to] + temp.weight;
					pq.offer(new Node(temp.to, minDistance[temp.to]));
				}
			} // '시작정점->temp.to에서 이동하는 거리'보다
		} 	  // '시작정점->pick.to->temp.to로 경유하는 거리'가 짧다면 업데이트
		
		for(int i = 1; i <= V; i++) {
			if(minDistance[i] == INF) {sb.append("INF\n");}
			else {sb.append(minDistance[i]+"\n");}
		}
		
		System.out.println(sb);
	}
}

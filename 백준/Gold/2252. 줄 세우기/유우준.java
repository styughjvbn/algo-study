import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { // 위상정렬
	static boolean[] visited;
	static int[] cnt; // 자신에게 연결된 edge 수
	static StringBuilder sb = new StringBuilder();
	
	static class Node {
		int val;
		Node next;
		
		public Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str = br.readLine();
		st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Node[] adjList = new Node[N + 1];
		visited = new boolean[N + 1];
		cnt = new int[N + 1];
		for(int i = 0; i < M; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to, adjList[from]);
			cnt[to] = cnt[to] + 1; // 자신에게 연결된 edge 수 기록 - 모든 정점의 진입차수를 계산
		}
		
		bfs_topological(adjList);
		System.out.println(sb);
	}

	private static void bfs_topological(Node[] adjList) {
		Queue<Integer> q = new ArrayDeque<>();
		
		while(true) {
			for(int i = 1; i < cnt.length; i++) {
				if(cnt[i] == 0) { q.add(i); cnt[i] = -1;}
			} // 진입 차수가 0인 노드를 큐에 모두 넣기
			// 이후, 중복 추가 방지를 위해 넣은 정점 진입차수를 -1로 변경
			
			if(q.isEmpty()) break;
			
			int front = q.poll();
			sb.append(front+" ");
			for(Node temp = adjList[front]; temp != null; temp = temp.next) {
				cnt[temp.val] = cnt[temp.val] - 1; // 자신에게 연결된 edge 진입 차수 감소
			}
		}
		
		for(int i = 1; i < cnt.length; i++) {
			if(cnt[i] != -1) {
				sb.append(i+" ");
			} // 순서 관계에 포함되지 않았던 나머지 모든 정점 출력
		}
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int N, M, V;
	private static int[][] map;
	private static boolean[] visitedDFS;
	private static StringBuilder stb;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		stb = new StringBuilder();
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		visitedDFS = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = map[y][x] = 1;
		}
		dfs(V);
		stb.append("\n");
		bfs(V);
		
		System.out.println(stb);
	} // end of main

	private static void dfs(int start) {
		visitedDFS[start] = true;
		stb.append(start).append(" ");
		for(int i=0; i<=N; i++) {
			if(map[start][i]!=0 && !visitedDFS[i]) {
				dfs(i);
			}
		}
	}

	private static void bfs(int start) {
		
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		
		q.offer(start);
		visited[start] = true;
		
		while(! q.isEmpty()) {
			int current = q.poll();
			stb.append(current).append(" ");
			for(int i=0; i<=N; i++) {
				if (map[current][i]!=0 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
	}
	
} // end of class

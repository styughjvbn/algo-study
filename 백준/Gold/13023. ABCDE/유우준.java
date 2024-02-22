import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static List<Integer>[] li;
	static boolean[] visited;
	static int res;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str = br.readLine();
		st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		li = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			li[i] = new ArrayList<>();
		}
		visited = new boolean[N];
		
		int a = -1; int b = -1;
		for(int i = 0; i < M; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			li[a].add(b);
			li[b].add(a);
		}
		
		for(int i = 0; i < N; i++) {
			visited[i] = true;
			dfs(i, 0);
			visited[i] = false;
			
			if(res == 1) {break;}
		}
		
		System.out.println(res);
		
	}

	private static void dfs(int index, int cnt) {
		if(cnt >= 4) {
			res = 1;
			return;
		}
		
		for(int i = 0; i < li[index].size(); i++) {
			if(!visited[li[index].get(i)]) {
				visited[li[index].get(i)] = true;
				dfs(li[index].get(i), cnt + 1);
				visited[li[index].get(i)] = false;
			}
		}
		
	}

//	private static void union(int par, int child) {
//		if(find(child) == find(par)) { return; } // 이미 같은 구성원 조합
//		
//		parents[find(child)] = find(par); // child의 대표를 par의 대표에 연결	
//	}
//
//	private static int find(int x) {
//		if(x == parents[x]) { return x; }
//		else return find(parents[x]); //parents[x] = find(parents[x]);
//	}
}

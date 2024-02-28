import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[] sushi, visited;
	private static int n, d, k, c;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken()); // 접시 수
		d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		int cnt= 0;
		sushi = new int[n];
		visited = new int[d+1];
		for(int i=0; i<n; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		cnt = 1;
		visited[c]++;
		for(int i=0; i<k; i++) {
			if(visited[sushi[i]]==0) cnt++;
			visited[sushi[i]]++;
		}
		int count = cnt;
		for(int i=1; i<n; i++) {
			visited[sushi[i-1]]--;
			if(visited[sushi[i-1]]==0) count--;
			if(visited[sushi[(i+k-1)%n]]==0) count++;
			visited[sushi[(i+k-1)%n]]++;
			cnt = Math.max(cnt, count);
		}
		System.out.println(cnt);
	}
}

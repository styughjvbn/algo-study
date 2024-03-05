import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//03/05(화) - <스터디> 최소 힙
public class S27_BJ_1927 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			int val = Integer.parseInt(br.readLine());
			
			if(val == 0) {
				if(pq.isEmpty()) { sb.append(0); }
				else { sb.append(pq.poll()); }
				sb.append("\n");
      }			
			else {
				pq.add(val);
			}
		}
		System.out.println(sb);
	}
}

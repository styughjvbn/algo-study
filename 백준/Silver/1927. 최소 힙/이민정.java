import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x==0) {
				if(pq.size()==0) stb.append(0).append("\n");
				else stb.append(pq.poll()).append("\n");
			} 
			else pq.add(x); 
		}
		System.out.println(stb);
	}

}

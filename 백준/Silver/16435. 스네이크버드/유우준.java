import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str = br.readLine();
		st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		List<Integer> li = new ArrayList<>();
		str = br.readLine();
		st = new StringTokenizer(str);

		for(int i = 0; i < N; i++) {
			li.add(Integer.parseInt(st.nextToken()));
		}
				
		Collections.sort(li);
		for(int i = 0; i < N; i++) {
			if(L >= li.get(i)) {L++;}
			else {break;}
		}
		System.out.println(L);

  }
}

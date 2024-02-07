import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		HashMap<Integer, Integer> map = new HashMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> B = new ArrayList<>();
		for(int i=0; i<n; i++) {
			B.add(Integer.parseInt(br.readLine()));
		}
		Set<Integer> set = new HashSet<>(B);
		Iterator<Integer> iterator = set.iterator();
		int max = 1;
		while(iterator.hasNext()) {
			int count = 1;
			int pre = B.get(0);
			int storage = iterator.next();
			for(int i=1; i<n; i++) {
				if (B.get(i) == storage) continue;
				else {
					if (pre == B.get(i)) {
						count++;
						max = Math.max(count, max);
					} else {
						count = 1;
						
					}
				}
				pre = B.get(i);
			}
		}
		System.out.println(max);
	}

}

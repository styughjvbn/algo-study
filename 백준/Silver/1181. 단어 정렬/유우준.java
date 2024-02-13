import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Set<String> s = new HashSet<>();
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			s.add(str);
		}
		
		Iterator<String> iter = s.iterator();
		PriorityQueue<String> pq = new PriorityQueue<>(new orderComparator());
		while(iter.hasNext()) {
			pq.add(iter.next());
		} // 중복을 거르기 위해 set을 한번 거침
		
		while(!pq.isEmpty()) {
			sb.append(pq.poll()+"\n");
		}
		System.out.println(sb);
	}
}
class orderComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		int o1Length = o1.length();
		int o2Length = o2.length();
		
		if(o1Length > o2Length) {return 1;} // 1:순서 바꾸기
		else if(o1Length == o2Length) {
			return o1.compareTo(o2); // 길이가 같으면 사전순
		}
		else {return -1;} // -1:조건에 만족하므로 그대로 두기
	}
	
}

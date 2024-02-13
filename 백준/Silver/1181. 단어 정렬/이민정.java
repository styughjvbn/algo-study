import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Set<String> alpha = new TreeSet<String>();
		for(int i=0; i<N; i++) {
			alpha.add(br.readLine());
		}
		ArrayList<String> alp = new ArrayList<String>(alpha);
		Collections.sort(alp, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() > o2.length()) return 1;
				else if (o1.length() < o2.length()) return -1;
				else return o1.compareTo(o2);
			}
			
		});
		for(int i=0; i<alp.size(); i++) {
			stb.append(alp.get(i)).append("\n");
		}
		System.out.println(stb);
	}
}

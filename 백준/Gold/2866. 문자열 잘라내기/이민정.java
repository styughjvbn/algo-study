import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		String[] col = new String[c];
		for(int i=0; i<r; i++) {
			String s = br.readLine();
			for(int j=0; j<c; j++) {
				if (i==0) col[j] = String.valueOf(s.charAt(j));
				else col[j] += String.valueOf(s.charAt(j));
			}
		}
		int count = 0;
		for(int i=1; i<r; i++) {
			Set<String> set = new HashSet<String>();
			for(int j=0; j<c; j++) {
				set.add(col[j].substring(i));
				if (set.size() != (j+1)) {
					System.out.println(count);
					return;
				}
			}
			count++;
		}
		System.out.println(count);
	}
}

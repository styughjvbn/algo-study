import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int L = str.length();
		String[] arr = new String[((L-2)*(L-1))/2];
		int idx = 0;
		for(int i=L-2; i>=1; i--) {
			String first = reverse_String(str.substring(0, i));
			for(int j=L-i-1; j>=1; j--) {
				String second = reverse_String(str.substring(i, i+j));
				String third = reverse_String(str.substring(i+j, L));
				arr[idx++] = (first.concat(second.concat(third)));
			}
		}
		Arrays.sort(arr);
		System.out.println(arr[0]);
		
	}

	public static String reverse_String(String str) {
		StringBuffer sb = new StringBuffer(str);
		return sb.reverse().toString();
	}
}

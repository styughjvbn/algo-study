import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();
		String[] str = new String[5];
		int max = 0;
		for(int i=0; i<5; i++) {
			str[i] = br.readLine();
			max = Math.max(max, str[i].length());
		}
		for(int idx=0; idx<max; idx++) {
			for(int i=0; i<5; i++) {
				if (str[i].length() > idx) stb.append(str[i].charAt(idx));
			}
		}
		System.out.println(stb);
	}
}

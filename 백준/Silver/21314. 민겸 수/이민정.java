import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{

	public static void main(String[] args) throws Exception{
		StringBuilder stb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String M = br.readLine();
		String min = "";
		String max = "";
		int cnt=0;
		for(int i=0; i<M.length(); i++) {
			if (M.charAt(i)=='M') {
				cnt++;
			} else {
				if (cnt>0) {
					min += ("1"+"0".repeat(cnt-1)+"5");
					max += ("5"+"0".repeat(cnt));
					cnt = 0;
				} else {
					min += "5";
					max += "5";
				}
			}
		}
		if (cnt>0) {
			min += ("1"+"0".repeat(cnt-1));
			max += ("1".repeat(cnt));
		}
		stb.append(max).append("\n").append(min);
		System.out.println(stb);
	}
}

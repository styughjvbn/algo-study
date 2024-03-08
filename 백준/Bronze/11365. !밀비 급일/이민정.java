import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();
		StringTokenizer st = null;
		while(true) {
			String str = br.readLine();
			if (str.equals("END")) break;
			StringBuffer s = new StringBuffer(str);
			stb.append(s.reverse().toString()).append("\n");
		}
		System.out.println(stb);
	}
}

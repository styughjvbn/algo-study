import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=1; i<=n; i++) {
			int cons = 0;
			for(int j=0; j<String.valueOf(i).length(); j++) {
				cons += String.valueOf(i).charAt(j) - '0';
			}
			cons += i ;
			if (cons==n) {
				System.out.println(i);
				break;
			}
			if (i == n) System.out.println(0);
		}
	}

}

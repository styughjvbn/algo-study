import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		while (n > 0) {
			if (n % 5 == 0) {
				cnt += (n / 5);
				n = 0;
				break;
			}
			n -= 3;
			cnt += 1;
		}
		if (n==0) System.out.println(cnt);
		else System.out.println(-1);
	}
}

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {
	public static int hap(int n) {
		int res = n;
		while (n>0) {
			res+=n%10;
			n/=10;
		}
		return res;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		int num = 0;
		for (int a=1; a<N; a++) {
			num=hap(a);
			if (num==N) {
				ans=a;
				break;
			}
		}
		System.out.println(ans);
	}
}

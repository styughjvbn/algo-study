import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		while(n>3) {
			if (n%3==0) {
				n-=3;
				count++;
			}
			else {
				n-=1;
				count++;
			}
		}
		if(n==3) count++;
		else {
			count += n;
		}
		if(count%2!=0) {
			System.out.println("SK");
		}else {
			System.out.println("CY");
		}
	}
}

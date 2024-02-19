import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int turn = 1;
		while(N != 0) {
			if(N > 3) {
				N--;
				turn ^= 1;
			}
			else {
				N -= 3;
				turn ^= 1;
			}
		}
		
		if(turn == 0) { 
			System.out.println("SK");
		}
		else {
			System.out.println("CY");
		}
	}
}

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+2];
		arr[2] = 1;
		for (int a=3; a<N+2; a++) {
			if (a%2==1) {
				arr[a] = arr[a-1]*2 - (arr[a-2] - arr[a-3]);
			} else {
				arr[a] = arr[a-1]*2;
			}
		}
		System.out.println(arr[N+1]);
	}
}

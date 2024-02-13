import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int numbers[], N, input[], max;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		isSelected = new boolean[N];
		numbers = new int[N];
		max = Integer.MIN_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		permutation(0);
		System.out.println(max);
	} // end of main
	
	public static void permutation(int index) {
		if (index == N) {
			checked(Arrays.copyOf(numbers, N));
			return;
		}
		for(int i=0; i<N; i++) {
			if (isSelected[i]) continue;
			numbers[index] = input[i];
			isSelected[i] = true;
			permutation(index+1);
			isSelected[i] = false;
			numbers[index] = 0;
		}
	}

	public static void checked(int[] arr) {
		int total = 0;
		for(int i=0; i<N-1; i++) {
			total += Math.abs(arr[i] - arr[i+1]);
		}
		max = Math.max(max, total);
	}
}

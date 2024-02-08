import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[] isSelected;
	static int[] input;
	static int[] output;
	static int max;
	
	public static void main(String[] args) throws Exception {
		// 순열 NPN = N * N-1 * ... * 1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		output = new int[N];
		isSelected = new boolean[N];
		
		String str = br.readLine();
		st = new StringTokenizer(str);
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		recursion(0);
		System.out.println(max);
	}

	private static void recursion(int index) {
		if(index == N) {
			int val = 0;
			for(int i = 0; i < N - 1; i++) {
				val += Math.abs(output[i] - output[i+1]);
			}
			if(val > max) {max = val;}
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				output[index] = input[i];
				recursion(index + 1);
				isSelected[i] = false;
			}
		}
	}
}

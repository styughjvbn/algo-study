import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] difficulty, input;
	static int N, y;  // nCy 
	private static int L, R, X, count=0;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		input = new int[N];  // 문제 난이도
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=2; i<=N; i++) { // 2<=y<=N
			y = i;
			difficulty = new int[y];
			combination(0, 0);
		}
		System.out.println(count);
	} // end of main
	
	public static void combination(int index, int start){
		if (index==y) {
			checked(Arrays.copyOf(difficulty, y));
			return;
		}
		for (int a=start; a<N; a++) {
			difficulty[index] = input[a];
			combination(index+1, a+1);
		}
	}

	public static void checked(int[] difficulty) {
		
		Arrays.sort(difficulty);
		if (difficulty[y-1] - difficulty[0] < X) return;
		int totalSum = 0;
		for(int i=0; i<y; i++) {
			totalSum += difficulty[i];
		}
		if ((L <= totalSum) && (totalSum <= R)) count++;
	}

} // end of class

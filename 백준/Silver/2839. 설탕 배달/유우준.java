import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int res = 0;
		while(true) {
			if(N % 5 == 0) {
				res += N/5;
				N = 0;
				break;
			}
			else if(N >= 3) {
				res++;
				N -= 3;
			}
			else if(N < 3) {
				res = -1;
				break;
			}
		}
		System.out.println(res);
	}
//	576ms
//	static int N;
//	static int[] input;
//	static List<Integer> output;
//	static int total;
//	static int min_cnt = Integer.MAX_VALUE;
//	
//	public static void main(String[] args) throws Exception { // 중복조합
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		N = Integer.parseInt(br.readLine());
//		input = new int[] {3,5};
//		output = new ArrayList<>();
//		
//		recursion(0);
//		
//		if(min_cnt == Integer.MAX_VALUE) {System.out.println(-1);}
//		else {System.out.println(min_cnt);}
//	}
//
//	private static void recursion(int start) {
//		if(total > N) {
//			return;
//			}
//		else if(total == N) {
//			min_cnt = Math.min(min_cnt, output.size());
//			return;
//		}
//		
//		for(int i = start; i < 2; i++) {
//			output.add(input[i]);
//			total += input[i];
//			
//			recursion(i);
//			
//			output.remove(output.get(output.size()-1));
//			total -= input[i];
//		}
//	}
}

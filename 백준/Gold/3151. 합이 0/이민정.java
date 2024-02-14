import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] scores = new int[n];
		long count = 0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(scores);
        for(int i=0; i<n; i++) {
			if (scores[i] > 0) break;
			int num = scores[i];
			int left = i+1;
			int right = n-1;
			while(left < right) {
				int sum = num + scores[left] + scores[right];
				if (sum == 0) {
					int L = 1;
					int R = 1;
					if (scores[left] == scores[right]) {
						count += Comb(right - left + 1);
						break;
					}
					while (scores[left] == scores[left+1]) {
						L++;
						left++;
					}
					while (scores[right] == scores[right-1]) {
						R++;
						right--;
					}
					count += (L * R);
				}
				if (sum > 0) {
					right--;
				} else {
					left++;
				}
			}
		}
        System.out.println(count);
		
	} // end of main
    
    public static int Comb(int n){
        return n * (n-1) / 2;
    }
    	
} // end of class

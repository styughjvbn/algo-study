import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] people = new int[n];
		for(int i=0; i<n; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(people);
		int total = 0;
		for(int i=0; i<n; i++) {
			total += (people[i]*(n-i));
		}
		System.out.println(total);
	}
}

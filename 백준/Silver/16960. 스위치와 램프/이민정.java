import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	private static int n, m, lamp[], switches[][];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		lamp = new int[m+1];
		switches = new int[n+1][];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			switches[i] = new int[num];
			for(int j=0; j<num; j++) {
				int L = Integer.parseInt(st.nextToken());
				switches[i][j] = L;
				lamp[L]++;
			}
		}
		
		for(int i=1; i<=n; i++) {
			if (ispossible(i)) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
	}

	private static boolean ispossible(int idx) {
		boolean flag = true;
		for(int num : switches[idx]) {
			lamp[num]--;
			if(lamp[num] <= 0) {
				flag = false;
			}
		}
		for(int num : switches[idx]) {
			lamp[num]++;
		}
		return flag;
	}

}

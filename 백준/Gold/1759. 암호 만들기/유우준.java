import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		
		String str = br.readLine();
		st = new StringTokenizer(str);
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		str = br.readLine();
		st = new StringTokenizer(str);
		int[] alps = new int[C];
		for(int i = 0; i < C; i++) {
			alps[i] = st.nextToken().charAt(0) - 'a';
		} // 오름차순 정렬을 위해서 알파벳을 숫자로 변환
		Arrays.sort(alps);
		
		int[] p = new int[C];
		for(int i = L; i < C; i++) {p[i] = 1;} // 0이 선택, 1이 미선택
		do {
			String res = "";
			int cntA = 0; int cntB = 0; // 모음 cntA, 자음 cntB 세기
			for(int i = 0; i < C; i++) {
				if(p[i] == 0) {
					char alp = (char)(alps[i] + 'a');
					res += alp;
					if(alp == 'a' || alp == 'e' || alp == 'i' ||
							alp == 'o' || alp == 'u') {cntA++;} // 모음
					else {cntB++;} // 자음
				}		
			}
			
			if(cntA >= 1 && cntB >= 2) {sb.append(res+"\n");} // 조건 만족 시 append
		} while(np(p));
		
		System.out.println(sb);
	}

	private static boolean np(int[] p) {
		int i = p.length - 1;
		while(i > 0 && p[i - 1] >= p[i]) {i--;}
		if(i == 0) return false;
		
		int j = p.length - 1;
		while(p[i - 1] >= p[j]) {j--;}
		
		swap(p, i - 1, j);
		int k = p.length - 1;
		while(i < k) {swap(p, i++, k--);}
		return true;
	}

	private static void swap(int[] p, int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}
}

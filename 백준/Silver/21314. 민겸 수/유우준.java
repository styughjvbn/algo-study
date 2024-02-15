import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 가장 큰 수 - K가 나올 때까지 M 개수를 킵
		// 			(1) K 없이 끝나면 M을 10^N 수로 변환
		//			(2) K 가 나오면 바로 5 x 10^N 수로 변환
		// 가장 작은 수 - K를 즉시 5로 변환
		
		String str = br.readLine();
		String max_res = "";
		char prev = ' '; int cnt_M = 0;
		for(int idx = 0; idx < str.length(); idx++) {
			char pick = str.charAt(idx);
			
			if(prev == ' ' && pick == 'M') {
				cnt_M++;
			} // 처리 끝 X
			else if(prev == ' ' && pick == 'K') {
				max_res += '5';
			} // 처리 끝 완료
			else if(prev == 'M' && pick == 'M') {
				cnt_M++;
			} // 처리 끝 X
			else if(prev == 'M' && pick == 'K') {
				max_res += '5';
				while(--cnt_M >= 0) {max_res += '0';}
				cnt_M = 0;
			} // 처리 끝 완료
			else if(prev == 'K' && pick == 'M') {
				cnt_M++;
			} // 처리 끝 X
			else if(prev == 'K' && pick == 'K') {
				max_res += '5';
			} // 처리 끝 완료
			
			prev = pick;
		}		
		if(str.charAt(str.length() - 1) == 'M') {
			while(--cnt_M >= 0) {max_res += '1';}
		}
		
		// 가장 작은 수 - K를 즉시 5로 변환
		String min_res = "";
		prev = ' '; cnt_M = 0;
		for(int idx = 0; idx < str.length(); idx++) {
			char pick = str.charAt(idx);
			
			if(prev == ' ' && pick == 'M') {
				cnt_M++;
			} // 처리 끝 X
			else if(prev == ' ' && pick == 'K') {
				min_res += '5';
			} // 처리 끝 완료
			else if(prev == 'M' && pick == 'M') {
				cnt_M++;
			} // 처리 끝 X
			else if(prev == 'M' && pick == 'K') {
				min_res += '1';
				while(--cnt_M > 0) {min_res += '0';}
				cnt_M = 0;
				min_res += '5';
			} // 처리 끝 완료
			else if(prev == 'K' && pick == 'M') {
				cnt_M++;
			} // 처리 끝 X
			else if(prev == 'K' && pick == 'K') {
				min_res += '5';
			} // 처리 끝 완료
			
			prev = pick;
		}
		if(str.charAt(str.length() - 1) == 'M') {
			min_res += '1';
			while(--cnt_M > 0) {min_res += '0';}
		}
		
		System.out.println(max_res);
		System.out.println(min_res);
	}
}

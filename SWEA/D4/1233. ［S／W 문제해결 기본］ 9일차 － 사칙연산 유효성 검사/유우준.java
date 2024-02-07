import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//02/06(화) - <실습> 사칙연산 유효성 검사
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int res;
		for(int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			res = 1;
			
			for(int i = 0; i < N; i++) {
				// info[0]은 정점 번호, info[1]은 정점 값, info[2-3]은 자식 정점 번호
				String[] info = br.readLine().split(" ");

				// 리프노드 X : 입력값 3,4개(정점 번호, 정점 값, 왼쪽 자식 정점 번호, (오른쪽 자식 정점 번호))
				// 리프노드 O : 입력값 2개(정점 번호, 정점 값)	
				if(info.length >= 3 && (info[1].equals("+") || info[1].equals("-") || info[1].equals("*") || info[1].equals("/"))) {
					;
				} // 리프노드 X인 경우 - 정상입력인지 판단(무조건 연산자)
				else if(info.length == 2 && info[1].charAt(0) >= '0' && info[1].charAt(0) <= '9') {
					;
				} // 리프노드 O인 경우 - 정상입력인지 판단(무조건 숫자)
				else {
					res = 0;
					for(int j = i + 1; j < N; j++) {
						br.readLine();
					} // 이미 연산 불가임이 확인되었으므로, 나머지 입력들 다 버림
					break;
				} // 연산 불가
			}
			sb.append("#"+test_case+" "+res+"\n");
		}
		System.out.println(sb);
	}
}

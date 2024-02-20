import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new ArrayDeque<>();
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			st = new StringTokenizer(str);
			String command = st.nextToken();
			
			if(command.equals("push")) {
				int X = Integer.parseInt(st.nextToken());
				dq.add(X);
			}
			else if(command.equals("pop")) {
				if(!dq.isEmpty()) {sb.append(dq.poll()+"\n");}
				else {sb.append(-1+"\n");}
			}
			else if(command.equals("size")) {
				sb.append(dq.size()+"\n");
			}
			else if(command.equals("empty")) {
				if(!dq.isEmpty()) {sb.append(0+"\n");}
				else {sb.append(1+"\n");}
			}
			else if(command.equals("front")) {
				if(!dq.isEmpty()) {sb.append(dq.peek()+"\n");}
				else {sb.append(-1+"\n");}
			}
			else if(command.equals("back")) {
				if(!dq.isEmpty()) {sb.append(dq.peekLast()+"\n");}
				else {sb.append(-1+"\n");}
			}
		}
		System.out.println(sb);
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	
	static Queue<Integer> q = new ArrayDeque<>();
	static StringBuilder stb = new StringBuilder();
	static int last = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			String cmd = br.readLine();
			func(cmd);
		}
		System.out.println(stb);
	} // end of main
	
	private static void func(String cmd) {
		int num=0;
		if (cmd.contains("push")) {
			num = Integer.parseInt(cmd.split(" ")[1]);
			cmd = cmd.split(" ")[0];
		}

		switch (cmd) {
		
		case "push" :
			q.offer(num);
			last = num;
			break;
			
		case "pop" :
			if(!q.isEmpty()) {
				stb.append(q.poll()).append("\n");
			} else {
				stb.append(-1).append("\n");
			}
			break;
			
		case "size" :
			stb.append(q.size()).append("\n");
			break;
			
		case "empty" :
			if (q.isEmpty()) stb.append(1).append("\n");
			else stb.append(0).append("\n");
			break;
		
		case "front" :
			if (!q.isEmpty()) stb.append(q.peek()).append("\n");
			else stb.append(-1).append("\n");
			break;
			
		case "back" :
			if (!q.isEmpty()) stb.append(last).append("\n");
			else stb.append(-1).append("\n");
			break;
		}
	}
} // end of class

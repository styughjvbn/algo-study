import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder stb = new StringBuilder();
	static HashMap<String, String[]> tree = new HashMap<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String root = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();
			tree.put(root, new String[] {left, right});
		}
		preOrder("A");
		stb.append("\n");
		InOrder("A");
		stb.append("\n");
		postOrder("A");
		stb.append("\n");
		System.out.println(stb);
	} // end of main

	private static void preOrder(String root) {
		if (!root.equals(".")) {
			stb.append(root);
			preOrder(tree.get(root)[0]);
			preOrder(tree.get(root)[1]);
		}
	}
	
	private static void InOrder(String root) {
		if (!root.equals(".")) {
			InOrder(tree.get(root)[0]);
			stb.append(root);
			InOrder(tree.get(root)[1]);
		}		
	}

	private static void postOrder(String root) {
		if (!root.equals(".")) {
			postOrder(tree.get(root)[0]);
			postOrder(tree.get(root)[1]);
			stb.append(root);
		}		
	}
	
} // end of class

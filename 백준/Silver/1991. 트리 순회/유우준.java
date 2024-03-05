
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//03/05(화) - <스터디> 트리 순회
public class S27_BJ_1991 {
	public static class Node {
		char par;
		char left;
		char right;
		
		public Node(char par, char left, char right) {
			this.par = par;
			this.left = left;
			this.right = right;
		}
	}
	
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
//		 노드의 개수 최대 26 -> 2^26 - 1 = 67108864 - 1		
		int N = Integer.parseInt(br.readLine());
		Node[] node = new Node[N];
				
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			char par = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			node[par - 'A'] = new Node(par, left, right);
		}
		
		sb = new StringBuilder();
		
		preOrder(node, 0);
//		System.out.println();
		sb.append("\n");
		
		inOrder(node, 0);
//		System.out.println();
		sb.append("\n");
		
		postOrder(node, 0);
//		System.out.println();
		sb.append("\n");
		
		System.out.println(sb);
	}

	private static void preOrder(Node[] node, int idx) {
//		System.out.print(node[idx].par);
		sb.append(node[idx].par);
		
		if(node[idx].left != '.') {
			preOrder(node, node[idx].left - 'A');
		}
		if(node[idx].right != '.') {
			preOrder(node, node[idx].right - 'A');
		}
	}
	private static void inOrder(Node[] node, int idx) {
		if(node[idx].left != '.') {
			inOrder(node, node[idx].left - 'A');
		}
		
//		System.out.print(node[idx].par);
		sb.append(node[idx].par);
		
		if(node[idx].right != '.') {
			inOrder(node, node[idx].right - 'A');
		}
	}
	private static void postOrder(Node[] node, int idx) {
		if(node[idx].left != '.') {
			postOrder(node, node[idx].left - 'A');
		}
		if(node[idx].right != '.') {
			postOrder(node, node[idx].right - 'A');
		}
		
//		System.out.print(node[idx].par);
		sb.append(node[idx].par);
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		StringBuilder stb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<Integer, String> pokemon1 = new HashMap<>();
		HashMap<String, Integer> pokemon2 = new HashMap<>();
		for(int i=1; i<=n; i++) {
			String input = br.readLine();
			pokemon1.put(i, input);
			pokemon2.put(input, i);
		}
		for(int i=0; i<m; i++) {
			String input = br.readLine();
			if(Character.isDigit(input.charAt(0))) {
				stb.append(pokemon1.get(Integer.parseInt(input))).append("\n");
			} else {
				stb.append(pokemon2.get(input)).append("\n");
			}
		}
		System.out.println(stb);
	}
}

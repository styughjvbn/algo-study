import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] dic = new String[str.length()];
		
		for(int i=0; i<str.length(); i++) {
			dic[i] = str.substring(i);
		}
		
		Arrays.sort(dic);
		
		for(String s : dic)
			System.out.println(s);
	}

}

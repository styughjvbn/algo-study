import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static String[] str, pwd;
	private static int L, C; 
	private static StringBuilder stb; 
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		stb = new StringBuilder();
		L = Integer.parseInt(st.nextToken()); 
		C = Integer.parseInt(st.nextToken()); 
		str = new String[C];  
		pwd = new String[L]; 
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<C; i++) {
			str[i] = st.nextToken();
		}
		Arrays.sort(str);
		make(0, 0);
		System.out.println(stb);
	}

	private static void make(int index, int start) {
		if(L == index) {
			if(checked()) {
				for(String s : pwd) stb.append(s);
				stb.append("\n");
			}
			return;
		}
		for(int i=start; i<C; i++) {
			pwd[index] = str[i];
			make(index+1, i+1);
		}
	}

	private static boolean checked() {
		int v = 0;
		int c = 0;
		for(int i=0; i<L; i++) {
			if(pwd[i].equals("a") || pwd[i].equals("e")
					|| pwd[i].equals("i") || pwd[i].equals("u")
					|| pwd[i].equals("o")) {
				v++;
			} else {
				c++;
			}
		}
		if(v>=1 && c>=2) return true;
		else return false;
	}
}

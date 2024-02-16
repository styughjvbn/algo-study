import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static StringBuilder change(StringBuilder str, int num) {
		StringBuilder m = new StringBuilder("1");
		StringBuilder m_Max = new StringBuilder();
		int k = 0;
		for (int a=0; a<str.length(); a++) {
			if (str.substring(a, a+1).equals("M")) {
				m.append("0");
				m_Max.append("1");
			} else {
				k += 1;
			}
		}
		if (k==1) {
			m.setCharAt(0, '5');
		} else {
			if (num==0) {
				return m_Max;
			} else {
				m.deleteCharAt(m.length()-1);
			}
		}
		return m;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder Max = new StringBuilder();
		StringBuilder Max_tmp = new StringBuilder();
		for (int a=0; a<s.length(); a++) {
			Max_tmp.append(s.charAt(a));
			if (s.charAt(a)=='K') {
				Max.append(change(Max_tmp, 0));
				Max_tmp = new StringBuilder();
			}
		}
		if (Max_tmp.length()>0) {
			Max.append(change(Max_tmp, 0));
		}
		StringBuilder Min = new StringBuilder();
		StringBuilder Min_tmp = new StringBuilder();
		for (int a=0; a<s.length()-1; a++) {
			if (s.charAt(a)=='M' ) {
				Min_tmp.append(s.charAt(a));
				if (s.charAt(a+1)=='K') {
					Min.append(change(Min_tmp, 1));
					Min_tmp = new StringBuilder();
				}
			} else {
				Min_tmp.append(s.charAt(a));
				Min.append(change(Min_tmp, 1));
				Min_tmp = new StringBuilder();				
			}
		}
		if (s.charAt(s.length()-1)=='M') {
			Min_tmp.append('M');
			Min.append(change(Min_tmp, 1));
		} else {
			Min_tmp.append('K');
			Min.append(change(Min_tmp, 1));
		}
		System.out.println(Max);
		System.out.println(Min);
	}
}

package study;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String ans = "z";
		int L = s.length();
		for (int a=1; a<L-1; a++) {
			for (int b=a+1; b<L; b++) {
				StringBuilder st = new StringBuilder(s.substring(0, a)).reverse();
				StringBuilder nd = new StringBuilder(s.substring(a, b)).reverse();
				StringBuilder rd = new StringBuilder(s.substring(b, L)).reverse();
				StringBuilder tmp = new StringBuilder();
				tmp.append(st).append(nd).append(rd);
				if (ans.compareTo(tmp.toString())>0) {
					ans = tmp.toString();
				}
			}
		}
		System.out.println(ans);
	}
}
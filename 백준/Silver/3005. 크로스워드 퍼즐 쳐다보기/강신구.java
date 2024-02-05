package baekjoon;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static String ans = "z";
	static StringBuilder tmp;
	
	public static void check() {
		if (tmp.length()>1 && ans.compareTo(tmp.toString())>0) {
			ans = tmp.toString();
		} 
		tmp = new StringBuilder();
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(s.nextToken());
		int M = Integer.parseInt(s.nextToken());
		String[] arr = new String[N];
		for (int a=0; a<N; a++) {
			arr[a] = br.readLine();
		}
		ans = "z";
		for (int a=0; a<N; a++) {
			tmp = new StringBuilder();
			for (int b=0; b<M; b++) {
				if (arr[a].charAt(b)=='#') {
					check();
				} else {
					tmp.append(arr[a].charAt(b));
				}
			}
			check();
		}
		for (int b=0; b<M; b++) {
			tmp = new StringBuilder();
			for (int a=0; a<N; a++) {
				if (arr[a].charAt(b)=='#') {
					check();
				} else {
					tmp.append(arr[a].charAt(b));
				}
			}
			check();
		}
		System.out.println(ans);
    }
}

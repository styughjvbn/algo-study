import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		char[][] puzzle = new char[r][c];
		for(int i=0; i<r; i++) {
			puzzle[i] = br.readLine().toCharArray();
		}
		ArrayList<String> words = new ArrayList<String>();
		for(int i=0; i<r; i++) {
			String word = "";
			for(int j=0; j<c; j++) {
				if (puzzle[i][j] != '#') {
					word = word.concat(Character.toString(puzzle[i][j]));
				}
				else {
					if (word.length() >= 2) {
						words.add(word);
					}
					word = "";
				}
			}
			if (word.length() >= 2) {
				words.add(word);
			}
		}
		for(int j=0; j<c; j++) {
			String word = "";
			for(int i=0; i<r; i++) {
				if (puzzle[i][j] != '#') {
					word = word.concat(Character.toString(puzzle[i][j]));
				}
				else {
					if (word.length() >= 2) {
						words.add(word);
					}
					word = "";
				}
			}
			if (word.length() >= 2) {
				words.add(word);
			}
		}
		Collections.sort(words);
		System.out.println(words.get(0));
		
		
	} // end of main
} // end of class

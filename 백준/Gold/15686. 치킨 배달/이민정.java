import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point{
	int r, c;
	public Point() {}
	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main {
	
	
	private static int n, m, result, map[][];
	private static ArrayList<Point> house, chicken;
	private static boolean[] open;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		result = Integer.MAX_VALUE;
		map = new int[n+1][n+1];
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=n; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if (num == 1) house.add(new Point(i, j));
				else if (num == 2) chicken.add(new Point(i, j));
			}
		}
		open = new boolean[chicken.size()];
		checked(0, 0);
		System.out.println(result);
		
	} // end of main

	private static void checked(int idx, int cnt) {
		if (cnt == m) {
			int total = 0;
			for(int i=0; i<house.size(); i++) {
				int distance = Integer.MAX_VALUE;
				for(int j=0; j<chicken.size(); j++) {
					if(open[j]) {
						int d = Math.abs(chicken.get(j).r - house.get(i).r) 
								+ Math.abs(chicken.get(j).c - house.get(i).c);
						distance = Math.min(distance, d);
					}
				}
				total += distance;
			}
			result = Math.min(result, total);
			return;
		}
		
		for(int i=idx; i<chicken.size(); i++) {
			if (!open[i]) {
				open[i] = true;
				checked(i+1, cnt+1);
				open[i] = false;
			}
		}
	}
	
} // end of class

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long N;
	static long R;
	static long C;
	static long ans = -1;
	
	public static void start(long y, long x, long l, long cnt) {
		if (l==2) {
			for (int a=0; a<l; a++) {
				for (int b=0; b<l; b++) {
					cnt+=1;
					if ((y+a)==R && (x+b)==C) {
						ans = cnt;
						return;
					}
				}
			}
			return;
		}
		if (y<=R && R<y+l/2 && x<=C && C<x+l/2) {
			start(y,x,l/2, cnt);
		} else if (y<=R && R<y+l/2 && x+l/2<=C && C<x+l) {
			start(y, x+l/2, l/2, cnt+l*l/4);
		} else if (y+l/2<=R && R<y+l && x<=C && C<x+l/2) {
			start(y+l/2, x, l/2, cnt+l*l/2);
		} else {
			start(y+l/2, x+l/2, l/2, cnt+l*l*3/4);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		N = Integer.parseInt(s.nextToken());
		R = Integer.parseInt(s.nextToken());
		C = Integer.parseInt(s.nextToken());
		long L = (long)Math.pow(2, N);
		start(0,0,L,-1);
		System.out.println(ans);
	}
}

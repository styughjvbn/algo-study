import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		double min = L;
        min = Math.min(min, W);
        min = Math.min(min, H);
        
        double start = 0;
        double end = min;
        double mid;
        while(start<end){
            mid = (start + end) / 2;
            if ((long)(L/mid) * (long)(W/mid) * (long)(H/mid) < N){
                if (end == mid) break;
                end = mid;
            } else{
                if (start == mid) break;
                start = mid;
            }
        }
		System.out.println(start);
	}

}

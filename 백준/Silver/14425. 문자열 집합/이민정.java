import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        HashSet<String> hash = new HashSet<String>();
        for(int i=0; i<n; i++){
            hash.add(br.readLine());
        }
        int count = 0;
        for(int i=0; i<m; i++){
            if (hash.contains(br.readLine())) count++;
        }
        System.out.println(count);
    }
}

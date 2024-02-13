import java.io.*;
import java.util.*;
 
public class Solution {
 
    public static void main(String[] args) throws Exception{
        StringBuilder stb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int tc=1; tc<=10; tc++) {
            stb.append("#").append(tc).append(" ");
            int n = Integer.parseInt(br.readLine());
            int answer = 1;
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                st.nextToken();
                char node = st.nextToken().charAt(0);
                 
                if(st.hasMoreTokens()) { 
                    if(node >= '0' && node <= '9') {  
                        answer = 0;
                    }
                }else { 
                    if(node < '0' || node > '9') { 
                        answer = 0;
                    }
                }
            }
            stb.append(answer).append("\n");
        }
        System.out.println(stb);
 
    }
}

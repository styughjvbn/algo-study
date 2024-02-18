import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
 
    private static String[][] map;
    private static String[] cmd;
    private static int H, W, n;
    private static StringBuilder stb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        stb = new StringBuilder();
        StringTokenizer st;
        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new String[H][W];
            int curR = 0;
            int curC = 0;
            for(int i=0; i<H; i++) {
                String s = br.readLine();
                for(int j=0; j<W; j++) {
                    map[i][j] = String.valueOf(s.charAt(j));
                    if (map[i][j].equals("^") ||
                            map[i][j].equals("v") ||
                            map[i][j].equals("<") ||
                            map[i][j].equals(">")) {
                        curR = i;
                        curC = j;
                    }
                }
            }
            n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            cmd = new String[n];
            for(int i=0; i<n; i++) {
                cmd[i] = String.valueOf(s.charAt(i));
            }
            game(curR, curC);
            stb.append("#").append(t).append(" ");
            for(int i=0; i<H; i++) {
                for(int j=0; j<W; j++) {
                    stb.append(map[i][j]);
                }
                stb.append("\n");
            }
        }
        System.out.println(stb);
    } // end of main
     
    private static void game(int r, int c) {
        for(int i=0; i<cmd.length; i++) {
            switch(cmd[i]) {
             
            case "U": // 위로
                if (0<=r-1 && r-1<H && map[r-1][c].equals(".")) {
                    map[r--][c] = ".";
                }
                map[r][c] = "^";
                break;
                 
            case "D": // 아래로
                if (0<=r+1 && r+1<H && map[r+1][c].equals(".")) {
                    map[r++][c] = ".";
                }
                map[r][c] = "v";
                break;
                 
            case "L": // 왼쪽으로
                if (0<=c-1 && c-1<W && map[r][c-1].equals(".")) {
                    map[r][c--] = ".";
                }
                map[r][c] = "<";
                break;
                 
            case "R": // 오른쪽으로
                if (0<=c+1 && c+1<W && map[r][c+1].equals(".")) {
                    map[r][c++] = ".";
                }
                map[r][c] = ">";
                break;
                 
            case "S": // 포탄, 벽에 충돌할때까지, 벽돌벽은 평지로
                String dir = map[r][c];
                if (dir.equals("^")) {
                    int x = r;
                    while(x>=0) {
                        if (x-1 < 0) break;
                        x--;
                        if(map[x][c].equals("*")) {
                            map[x][c] = ".";
                            break;
                        } else if (map[x][c].equals("#")) {
                            break;
                        }
                    }
                } else if (dir.equals("v")) {
                    int x = r;
                    while(x<H) {
                        if (x+1 >= H) break;
                        x++;
                        if(map[x][c].equals("*")) {
                            map[x][c] = ".";
                            break;
                        } else if (map[x][c].equals("#")) {
                            break;
                        }
                    }
                } else if (dir.equals(">")) {
                    int x = c;
                    while(x<W) {
                        if (x+1 >= W) break;
                        x++;
                        if(map[r][x].equals("*")) {
                            map[r][x] = ".";
                            break;
                        } else if (map[r][x].equals("#")) {
                            break;
                        }
                    }
                } else if (dir.equals("<")) {
                    int x = c;
                    while(x>=0) {
                        if (x-1 < 0) break;
                        x--;
                        if(map[r][x].equals("*")) {
                            map[r][x] = ".";
                            break;
                        } else if (map[r][x].equals("#")) {
                            break;
                        }
                    }
                }
                break;
            }
        }
    }
     
} // end of class

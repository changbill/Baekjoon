import java.util.*;
import java.io.*;

class Solution
{
    static char[] cards;
    static int N, len;
    static String answer;
    static boolean[][] dp;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= T; t++) {
            answer = "0";
            st = new StringTokenizer(br.readLine());
            cards = st.nextToken().toCharArray();
            N = Integer.parseInt(st.nextToken());
            len = cards.length;
            int x = 1;
            for(int i = 0; i < len; i++) {
            	x *= 10;
            }
            
            dp = new boolean[N+1][x];
            
            dfs(0);
            
            sb.append("#" + t + " " + answer).append('\n');
        }
        System.out.println(sb.toString());
    }
    
    static void dfs(int depth) {
    	if(depth == N) {
            String str = toString(cards);
            answer = answer.compareTo(str) >= 0 ? answer : str;
        	return;
        }
        
        for(int i = 0; i < len; i++) {
            for(int j = i+1; j < len; j++) {
                char tmp = cards[i];
                cards[i] = cards[j];
                cards[j] = tmp;
                String str = toString(cards);
                if(dp[depth][Integer.parseInt(str)]) {
                    cards[j] = cards[i];
                	cards[i] = tmp;
                    continue;
                }
                dp[depth][Integer.parseInt(str)] = true;
                
            	dfs(depth+1);
                
                cards[j] = cards[i];
                cards[i] = tmp;
            }
        }
    }
    
    static String toString(char[] chars) {
    	StringBuilder strB = new StringBuilder();
        for(char c : chars) {
        	strB.append(c);
        }
        return strB.toString();
    }
}
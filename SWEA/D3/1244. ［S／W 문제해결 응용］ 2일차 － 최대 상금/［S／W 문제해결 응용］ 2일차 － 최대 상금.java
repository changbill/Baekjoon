import java.util.*;
import java.io.*;

class Solution
{
    static char[] cards;
    static int N, len, answer;
    static boolean[][] visited = new boolean[11][1000000];
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= T; t++) {
            answer = 0;
            st = new StringTokenizer(br.readLine());
            cards = st.nextToken().toCharArray();
            N = Integer.parseInt(st.nextToken());
            len = cards.length;
            for(int i = 0; i <= N; i++) {
            	Arrays.fill(visited[i], false);
            }
            
            dfs(0);
            
            sb.append("#" + t + " " + answer).append('\n');
        }
        System.out.println(sb.toString());
    }
    
    static void dfs(int depth) {
        int now = Integer.parseInt(new String(cards));
        if(visited[depth][now]) return;
        visited[depth][now] = true;
        
    	if(depth == N) {
            answer = Math.max(answer, now);
        	return;
        }
        
        for(int i = 0; i < len; i++) {
            for(int j = i+1; j < len; j++) {
                char tmp = cards[i];
                cards[i] = cards[j];
                cards[j] = tmp;
                
            	dfs(depth+1);
                
                cards[j] = cards[i];
                cards[i] = tmp;
            }
        }
    }
}
import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
		for(int t = 1; t <= T; t++)
		{
			st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            char[][] coords = new char[H][W];
            for(int h = 0; h < H; h++) {
                String str = br.readLine();
            	for(int w = 0; w < W; w++) {
                	char c = str.charAt(w);
					coords[h][w] = c;
                }
            }
            
            boolean[] rows = new boolean[H];
            boolean[] cols = new boolean[W];
            boolean hasWhite =false;
            for(int h = 0; h < H; h++) {
            	for(int w = 0; w < W; w++) {
					if(coords[h][w] == '.') {
                        hasWhite = true;
                    	rows[h] = true;
                        cols[w] = true;
                    }
                }
            }
            
            if(!hasWhite) {
                int tmp = Math.min(H, W);
                sb.append(tmp).append('\n');
            	continue;
            }
            
            int cnt = 0;
            for(int h = 0; h < H; h++) {
            	if(!rows[h]) cnt++;
            }
            
            for(int w = 0; w < W; w++) {
                if(!cols[w]) cnt++;
            }
            
            sb.append(cnt).append('\n');
		}
        System.out.println(sb.toString());
	}
}
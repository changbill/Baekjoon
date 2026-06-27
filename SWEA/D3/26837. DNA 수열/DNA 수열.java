import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++)
		{
			st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            String str = st.nextToken().toString();
            int[][] atcg = new int[len+1][4];
            for(int i = 0; i < str.length(); i++) {
                char tmp = str.charAt(i);
                atcg[i+1][0] = atcg[i][0];
                atcg[i+1][1] = atcg[i][1];
                atcg[i+1][2] = atcg[i][2];
                atcg[i+1][3] = atcg[i][3];
                if(tmp == 'A') atcg[i+1][0]++;
                if(tmp == 'T') atcg[i+1][1]++;
                if(tmp == 'C') atcg[i+1][2]++;
                if(tmp == 'G') atcg[i+1][3]++;
            }
            
            int a, t, c, g;
            int answer = 0;
            for(int i = 0; i <= len; i++) {
                for(int j = i+2; j <= len; j += 2) {
                    a = atcg[j][0] - atcg[i][0];
                    t = atcg[j][1] - atcg[i][1];
                    c = atcg[j][2] - atcg[i][2];
                    g = atcg[j][3] - atcg[i][3];
                    
                    if(a == t && c == g) {
                    	answer++;
                    }
                }
            }
            
            sb.append(answer).append('\n');
		}
        
        System.out.println(sb.toString());
	}
}
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

        for(int t = 1; t <= T; t++) {
        	int N = Integer.parseInt(br.readLine());
            int[][] coordR = new int[20001][2]; // max, min
            int[][] coordC = new int[20001][2]; // max, min
            for(int i = 0; i <= 20000; i++) {
                coordR[i][0] = Integer.MIN_VALUE;
                coordC[i][0] = Integer.MIN_VALUE;
                coordR[i][1] = Integer.MAX_VALUE;
                coordC[i][1] = Integer.MAX_VALUE;
            }
            
            List<int[]> list = new ArrayList<>();
            for(int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken()) + 10000;
                int c = Integer.parseInt(st.nextToken()) + 10000;
                list.add(new int[]{r, c});
                coordR[r][0] = Math.max(coordR[r][0], c);
                coordR[r][1] = Math.min(coordR[r][1], c);
                coordC[c][0] = Math.max(coordC[c][0], r);
                coordC[c][1] = Math.min(coordC[c][1], r);
            } 
			
            int max = 0;
            for(int n = 0; n < N; n++) {
            	int[] coord = list.get(n);
                int r = coord[0];
                int c = coord[1];
                int x = Math.max(Math.abs(coordC[c][0] - r), Math.abs(r - coordC[c][1]));
                int y = Math.max(Math.abs(coordR[r][0] - c), Math.abs(c - coordR[r][1]));
                max = Math.max(max, x*y);
            }
            
            sb.append(max).append('\n');
        }
        System.out.println(sb.toString());
	}
}
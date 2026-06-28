import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int x, y, a, b;
		for(int t = 1; t <= T; t++)
		{
			st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            a = (x+y)/2;
            b = (x-y)/2;
           	sb.append(a).append(' ').append(b).append('\n');
		}
        
        System.out.println(sb.toString());
	}
}
import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
		for(int t = 1; t <= T; t++)
		{
			int X = Integer.parseInt(br.readLine());
            if(X == 1) {
            	sb.append(0).append('\n');
                continue;
            }
            int eight = X / 2;
            StringBuilder tmp = new StringBuilder();
            if(X % 2 != 0) {
            	tmp.append(4);
            }
            
            for(int i = 0; i < eight; i++) {
            	tmp.append(8);
            }
            
            sb.append(tmp.toString()).append('\n');
		}
        System.out.println(sb.toString());
	}
}
import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        loop:
		for(int t = 1; t <= T; t++)
		{
			st = new StringTokenizer(br.readLine());
            long S = Long.parseLong(st.nextToken());
            long P = Long.parseLong(st.nextToken());
            
            long left = 1;
            long right = S/2;
            while(left < right) {
            	long mid = (left + right) / 2;
                if(mid > P / (S-mid) || (P % mid == 0 && mid == P / (S-mid))) {
					right = mid;
                } else {
                    left = mid+1;
                }
            }
            if(P % left == 0 && left == P / (S-left)) System.out.println("Yes");
            else System.out.println("No");
		}
	}
}
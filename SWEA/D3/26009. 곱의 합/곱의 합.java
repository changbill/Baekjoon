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
        long MOD = 998244353;
        
		for(int t = 1; t <= T; t++)
		{
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            long i = a * (a+1)/2 % MOD;
            long j = b * (b+1)/2 % MOD;
            long k = c * (c+1)/2 % MOD;
            long answer = (i*j % MOD) * k % MOD;
            sb.append(answer).append('\n');
		}
        System.out.println(sb.toString());
	}
}
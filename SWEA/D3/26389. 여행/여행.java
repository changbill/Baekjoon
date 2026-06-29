import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
		for(int t = 1; t <= T; t++)
		{
			String str = br.readLine();
            Set<Character> set = new HashSet<>();
            for(int i = 0; i < str.length(); i++) {
            	char tmp = str.charAt(i);
                set.add(tmp);
            }
            
            if((set.contains('N') && !set.contains('S')) || (set.contains('S') && !set.contains('N')) || (set.contains('W') && !set.contains('E')) || (set.contains('E') && !set.contains('W'))) {
            	sb.append("No").append('\n');
                continue;
            }
            sb.append("Yes").append('\n');
		}
        
        System.out.println(sb.toString());
	}
}
import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        loop:
		for(int t = 1; t <= T; t++)
		{
			String str = br.readLine();
            char[] cArr = str.toCharArray();
            boolean[] visited = new boolean[cArr.length];
            int[] nums = new int[10];
            for(int i = 0; i < cArr.length; i++) {
                int num = cArr[i] - '0';
				nums[num]++;
                if(visited[i]) continue;
                visited[i] = true;
                if(i+num+1 >= cArr.length || num != cArr[i+num+1] - '0') {
                	sb.append("no").append('\n');
                    continue loop;
                }
                visited[i+num+1] = true;
            }
            
            for(int i =0; i< 10; i++) {
            	if(nums[i] != 0 && nums[i] != 2) {
                	sb.append("no").append('\n');
                    continue loop;
                }
            }
            sb.append("yes").append('\n');
		}
        System.out.println(sb.toString());
	}
}
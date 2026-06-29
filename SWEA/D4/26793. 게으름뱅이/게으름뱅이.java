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
        
		for(int t = 1; t <= T; t++)
		{
            Deque<int[]> dq = new ArrayDeque<>();
            List<int[]> list = new ArrayList<>();
			int N = Integer.parseInt(br.readLine());
            for(int n = 1; n <= N; n++) {
            	st = new StringTokenizer(br.readLine());
                int time = Integer.parseInt(st.nextToken());
                int deadline = Integer.parseInt(st.nextToken());
				list.add(new int[]{deadline - time, deadline});
            }
            
            Collections.sort(list, (a, b) -> a[1] - b[1]);
            for(int i = 0; i < list.size(); i++) {
            	int[] arr = list.get(i);
                int start = arr[0];
                int end = arr[1];
                while(!dq.isEmpty()) {
                	int[] last = dq.peekLast();
                	if(last[1] < start) break;
                    dq.pollLast();
                    start = last[0] - (last[1] - start);
                }
                dq.offerLast(new int[]{start, end});
            }
            
            int[] first = dq.pollFirst();
            sb.append(first[0]).append('\n');
		}
        System.out.println(sb.toString());
	}
}
import java.util.*;
import java.io.*;

class Solution
{
    static Set<Integer> set;
    static String str;
    static int onebyun, len;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= T; t++)
		{
			sb.append("#" + t + " ");
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            str = br.readLine();
            len = str.length();
            onebyun = len / 4;
            
            set = new HashSet<>();
            for(int i = 0; i < onebyun; i++) {
            	input();
                rotate();
            }
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list, Collections.reverseOrder());
            int answer = list.get(K-1);
            sb.append(answer).append('\n');
		}
        System.out.println(sb.toString());
	}
    
    static void input() {
        for(int i = 0; i < 4; i++) {
            int sum = 0;
        	for(int j = onebyun-1; j >= 0; j--) {
            	int idx = onebyun * i + onebyun - j -1;
                char c = str.charAt(idx);
                int num = 1;
                if(c >= 'A') {
                	num = c - 'A' + 10;
                } else {
                	num = c - '0';
                }
                
                for(int k = 0; k < j; k++) {
                	num *= 16;
                }
                sum += num;
            }
            set.add(sum);
        }
    }
    
    static void rotate() {
        String s = str.substring(1,len);
        str = s + str.charAt(0);
    }
}
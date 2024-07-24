import java.io.*;
import java.util.*;

// tip: each public class is put in its own file
public class Main
{
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int NArr[] = new int[N+1];
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            NArr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int start = 1;
        int end = 1;
        int sum = NArr[1];
        while(end <= N) {
            if(sum >= S) {
                int len = end - start + 1;
                min = Math.min(len, min);
                if(start + 1 > N) break;
                sum -= NArr[start++];
                if(sum == 0) {
                    if(end + 1 > N) break;
                    sum += NArr[++end];
                }
            } else {
                if(end + 1 > N) break;
                sum += NArr[++end];
            }
        }

        min = min == Integer.MAX_VALUE ? 0 : min;
        System.out.println(min);
    }
}
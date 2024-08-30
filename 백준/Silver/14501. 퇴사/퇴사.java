import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int dp[] = new int[N+2];
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            dp[i] = Math.max(dp[i], dp[i-1]);
            if(T+i > N+1) continue;
            dp[T+i] = Math.max(dp[T+i], dp[i] + P);
            max = Math.max(dp[T+i], max);
        }

        if(max == Integer.MIN_VALUE) {
            max = 0;
        }
        System.out.println(max);
    }
}